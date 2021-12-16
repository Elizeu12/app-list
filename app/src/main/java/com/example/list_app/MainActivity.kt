package com.example.list_app

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var listView: RecyclerView
    private lateinit var arrayList: ArrayList<ListData>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.idTextView)
        listView.layoutManager = LinearLayoutManager(this)
        listView.setHasFixedSize(true)

        arrayList = arrayListOf<ListData>()

        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/search/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: GitProjects = retrofit.create(GitProjects::class.java)
        val dadosProjects: Call<List<Item>> = service.listRepos()

        dadosProjects.enqueue(object : Callback<List<Item>?> {
            override fun onResponse(call: Call<List<Item>?>, response: Response<List<Item>?>) {
                if (!response.isSuccessful){
                    val responseBody = response.body()!!

                    for (dados in responseBody){
                        val listData = ListData(dados.full_name.toString())
                        arrayList.add(listData)
                    }
                    listView.adapter = Adapter(arrayList)
                }

            }

            override fun onFailure(call: Call<List<Item>?>, t: Throwable) {
                Log.e("MainActivity","Erro: " + t.message)
            }
        })
        /**string = arrayOf(
            "item",
            "item",
            "item",
            "item",
            "item",
        )
        */


    }
}

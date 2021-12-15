package com.example.list_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var listView: RecyclerView
    private lateinit var arrayList: ArrayList<ListData>
    lateinit var string: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        string = arrayOf(
            "item",
            "item",
            "item",
            "item",
            "item",
        )
        listView = findViewById(R.id.idTextView)
        listView.layoutManager = LinearLayoutManager(this)
        listView.setHasFixedSize(true)

        arrayList = arrayListOf<ListData>()
        getUserdata()
    }

    private fun getUserdata() {
        for (i in string.indices){
            val listData = ListData(string[i])
            arrayList.add(listData)
        }
        listView.adapter = Adapter(arrayList)
    }

}

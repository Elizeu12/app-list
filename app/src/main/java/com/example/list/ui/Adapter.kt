package com.example.list.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.list.R
import com.example.list.data.ListData
import com.squareup.picasso.Picasso


class Adapter(private val dataSet: ArrayList<ListData>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {


     //o ViewHolder é ofixador de visualização
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView: ImageView
        val starView: TextView
        val textForks: TextView
        val textLogin: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.textName)
            imageView = view.findViewById(R.id.imageView)
            starView = view.findViewById(R.id.starView)
            textForks = view.findViewById(R.id.textForks)
            textLogin = view.findViewById(R.id.textLogin)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        viewHolder.textLogin.text = "Autor: " + dataSet[position].login
        viewHolder.textForks.text = "Forks " + dataSet[position].forks.toString()
        viewHolder.starView.text = "⭐ " + dataSet[position].star.toString()
        viewHolder.textView.text = dataSet[position].string
        Picasso.get().load(dataSet[position].url).resize(100, 100).into(viewHolder.imageView)
    }


    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}




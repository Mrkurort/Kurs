package com.example.kotfisher

import android.content.Context
import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.time.Instant
import java.util.zip.Inflater

class myAdapter (ListArray:ArrayList<ListItem>, context: Context):
    RecyclerView.Adapter<myAdapter.ViewHolder>() {

    var ListArrar = ListArray
    var contextr = context

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val textTitle = view.findViewById<TextView>(R.id.textTitle)
        val imageViewFish = view.findViewById<ImageView>(R.id.imageViewFish)
        val TVContent = view.findViewById<TextView>(R.id.TVContent)

        fun bind(listItem: ListItem, context: Context){

            textTitle.text = listItem.titleText
            TVContent.text = listItem.contentText
            imageViewFish.setImageResource(listItem.image_id)
            itemView.setOnClickListener(){
                Toast.makeText(context, "Выбран: ${textTitle.text}", Toast.LENGTH_SHORT).show()

                val i = Intent(context, ContentActivity::class.java).apply {
                    putExtra("title", textTitle.text.toString())
                    putExtra("content", listItem.contentText)
                    putExtra("image", listItem.image_id)
                }

                context.startActivity(i)

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(contextr)
        return ViewHolder(inflater.inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int {

        return ListArrar.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var listItem=ListArrar.get(position)

        holder.bind(listItem,contextr)

    }

    fun updateAdapter(listArray: List<ListItem>){
        ListArrar.clear()
        ListArrar.addAll(listArray)
        notifyDataSetChanged()
    }
}
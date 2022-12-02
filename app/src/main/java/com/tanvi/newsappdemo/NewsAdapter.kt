package com.tanvi.newsappdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tanvi.newsappdemo.Model.Article

class NewsAdapter(val itemDataList:List<Article>):RecyclerView.Adapter<NewsAdapter.ItemViewHolder>() {
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView:ImageView=itemView.findViewById(R.id.ivImage)
        val textView:TextView=itemView.findViewById(R.id.tvHeadline)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_row,parent,false)
        return ItemViewHolder(view)
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data = itemDataList[position]
        Glide.with(holder.itemView.context)
            .load(data.urlToImage)
            .into(holder.imageView)
       // holder.imageView.setImageResource(data.image)
        holder.textView.text=data.title
    }
    override fun getItemCount(): Int {
        return itemDataList.size

    }

}
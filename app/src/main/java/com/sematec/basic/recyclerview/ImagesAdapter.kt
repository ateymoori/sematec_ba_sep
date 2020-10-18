package com.sematec.basic.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sematec.basic.R
import com.sematec.basic.entities.HitsEntity
import com.sematec.basic.utils.load
import kotlinx.android.synthetic.main.pixabay_recycler_list_item.view.*

class ImagesAdapter(val context: Context, val items: List<HitsEntity>) :
    RecyclerView.Adapter<ImagesAdapter.MyHolder>() {

    class MyHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val username: TextView = view.username
        val favCount: TextView = view.favCount
        val image: ImageView = view.image
        val avatar: ImageView = view.avatar
        val like: View = view.like
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val holder = MyHolder(
            LayoutInflater.from(context).inflate(
                R.layout.pixabay_recycler_list_item, parent, false
            )
        )

        holder.image.setOnClickListener {
            onImageClickListener.onImageClicked(items.get(holder.adapterPosition))
        }

        holder.avatar.setOnClickListener {
            onImageClickListener.onAvatarClicked(items.get(holder.adapterPosition))
        }
        holder.like.setOnClickListener {
            onImageClickListener.onLikeClicked(items.get(holder.adapterPosition))
        }

        return holder
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item = items.get(position)
        holder.username.text = item.user
        holder.favCount.text = item.favorites.toString()
        holder.image.load(context, item.webformatURL)
        holder.avatar.load(context, item.userImageURL)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    lateinit var onImageClickListener: ImageClickListener

    interface ImageClickListener {
        fun onImageClicked(image: HitsEntity)
        fun onAvatarClicked(image: HitsEntity)
        fun onLikeClicked(image: HitsEntity)
    }
}
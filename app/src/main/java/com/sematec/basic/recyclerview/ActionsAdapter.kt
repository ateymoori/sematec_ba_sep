package com.sematec.basic.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sematec.basic.R
import com.sematec.basic.utils.toast
import kotlinx.android.synthetic.main.actions_list_item.view.*

class ActionsAdapter(val context: Context, val items: List<String>) :
    RecyclerView.Adapter<ActionsAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.title
        val container: View = view.container
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val holder = MyViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.actions_list_item, parent, false
            )
        )

        holder.container.setOnClickListener {
            val clickedItem = items.get(holder.adapterPosition)
            actionClickHandler.onActionClickListener(clickedItem)
        }

        return holder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = items.get(position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    lateinit var actionClickHandler: ClickOnAction

    interface ClickOnAction {
        fun onActionClickListener(item: String)
    }

}
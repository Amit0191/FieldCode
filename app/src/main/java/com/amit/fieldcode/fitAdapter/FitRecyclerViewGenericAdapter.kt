package com.amit.fieldcode.fitAdapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amit.fieldcode.fitModel.FitModel
import com.amit.fieldcode.fitUtils.inflate

class FitRecyclerViewGenericAdapter(
    private val layout: Int,
    val onBind: (view: View, item: Any, position: Int) -> Unit,
    private val onViewClicked: (view: View, item: Any, position: Int) -> Unit
) : RecyclerView.Adapter<FitRecyclerViewGenericAdapter.ViewHolder>() {
    private val items = ArrayList<Any>()

    fun addItem(item: Any) {
        this.items.add(item)
        notifyItemInserted(items.size - 1)
    }

    fun addItems(items: ArrayList<FitModel>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun clearItems() {
        this.items.clear()
        notifyDataSetChanged()

    }

    class ViewHolder(
        private val view: View,
        val onBind: (view: View, item: Any, position: Int) -> Unit,
        val onViewClicked: (view: View, item: Any, position: Int) -> Unit
    ) : RecyclerView.ViewHolder(view) {

        fun bind(item: Any, position: Int) {
            onBind(view, item, position)

            view.setOnClickListener { onViewClicked(view, item, position) }
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        return ViewHolder(p0.inflate(layout), onBind, onViewClicked)
//        val view = LayoutInflater.from(p0.context).inflate(layout,p0,false)
//        return ViewHolder(view,onBind,onViewClicked)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        holder.bind(items[pos], pos)
    }

}

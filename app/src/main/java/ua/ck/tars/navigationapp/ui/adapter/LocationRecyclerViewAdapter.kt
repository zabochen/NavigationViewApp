package ua.ck.tars.navigationapp.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_item_checker.view.*
import ua.ck.tars.navigationapp.R

class LocationRecyclerViewAdapter : RecyclerView.Adapter<LocationRecyclerViewAdapter.MyViewHolder>() {

    private val items: ArrayList<Model> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.adapter_item_checker,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return if (items.isNullOrEmpty()) 0 else items.size
    }

    fun setItems(itemList: ArrayList<Model>) {
        items.apply {
            clear()
            addAll(itemList)
        }
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
            itemView.adapterItemChecker_checkBox.setOnClickListener(this)
        }

        fun bind(position: Int) {
            if (!items[position].checked) {
                itemView.adapterItemChecker_checkBox.isChecked = false
            } else {
                itemView.adapterItemChecker_checkBox.isChecked = true
            }
        }

        override fun onClick(p0: View?) {
            if (!items[adapterPosition].checked) {
                itemView.adapterItemChecker_checkBox.isChecked = true
                items[adapterPosition].checked = true
                Log.i("ADAPTER", "TRUE")
            } else {
                itemView.adapterItemChecker_checkBox.isChecked = false
                items[adapterPosition].checked = false
                Log.i("ADAPTER", "FALSE")
            }
        }
    }
}
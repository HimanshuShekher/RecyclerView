package com.example.assignmentapplication.adapter

import android.graphics.Color
import android.provider.CalendarContract.Colors
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentapplication.R
import com.example.assignmentapplication.data.DataResponse


class CustomerAdapter(private var originalList: List<DataResponse.ResponseData>) :
    RecyclerView.Adapter<CustomerAdapter.ViewHolderClass>() {

    private var filteredList: List<DataResponse.ResponseData> = originalList.toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolderClass(view)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val item = filteredList[position]

        val fullName = "${item.fName} ${item.lName}"
        holder.name.text = fullName

        // Alternate text colors based on position
        when (position % 3) {
            0 -> holder.name.setTextColor(holder.itemView.context.getColor(R.color.red))
            1 -> holder.name.setTextColor(holder.itemView.context.getColor(R.color.green))
            2 -> holder.name.setTextColor(holder.itemView.context.getColor(R.color.blue))
        }

        holder.mobile.text = item.mobileNo

        if (item.isCow == 1 && item.isBuffalo == 1) {
            holder.imageView.setImageResource(R.drawable.buffalo)
        } else {
            holder.imageView.setImageResource(R.drawable.cow)
        }
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    fun filter(query: String) {
        filteredList = if (query.isEmpty()) {
            originalList.toList()
        } else {
            originalList.filter { item ->
                item.fName.contains(query, true) ||
                        item.lName.contains(query, true) ||
                        item.mobileNo.contains(query, true)
            }
        }
        notifyDataSetChanged()
    }

    class ViewHolderClass(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name)
        val mobile: TextView = view.findViewById(R.id.mobile)
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }
}

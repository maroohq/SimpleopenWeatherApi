package com.example.apidemoopenweather

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.apidemoopenweather.placeholder.PlaceholderContent.PlaceholderItem
import com.example.apidemoopenweather.databinding.FragmentItemBinding
import com.example.apidemoopenweather.models.Forecast3hour

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyitemRecyclerViewAdapter(
    private val values: List<Forecast3hour>
) : RecyclerView.Adapter<MyitemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.tempcView.text = item.main.temp_min.toString()
        holder.temphView.text = item.main.temp_max.toString()
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val tempcView: TextView = binding.tempcText
        val temphView: TextView = binding.temphText

        override fun toString(): String {
            return super.toString()
        }
    }

}
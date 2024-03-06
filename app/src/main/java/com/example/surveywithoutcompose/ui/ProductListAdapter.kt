package com.example.surveywithoutcompose.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.surveywithoutcompose.data.LoginData
import com.example.surveywithoutcompose.databinding.ListItemBinding

class ProductListAdapter() : RecyclerView.Adapter<ProductListAdapter.DataViewHolder>() {

    lateinit var binding: ListItemBinding
    var productList = arrayListOf<LoginData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val filterModel = productList[position]
        holder.bind(filterModel)
    }

    override fun getItemCount(): Int = productList.size

    inner class DataViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(filterModel: LoginData) {
            binding.logindata = filterModel
            binding.executePendingBindings()
        }

    }

    fun setProducts(data: LoginData) {
        try {
            productList.clear()
//            if(data.isNotEmpty()){
                productList.addAll(listOf(data))
//            }
            notifyDataSetChanged()
        } catch (e: Exception) {
            e.stackTrace
        }
    }
}
package com.io.muhsin.zaakir.ui.menu.reference

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.io.muhsin.zaakir.databinding.ItemFbDataBinding
import com.io.muhsin.zaakir.models.Learning

class ReferenceAdapter(private var list: ArrayList<Learning>):
    RecyclerView.Adapter<ReferenceAdapter.ReferenceViewHolder>() {
    var onClickItem:((Learning)->Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReferenceViewHolder {
        return ReferenceViewHolder(ItemFbDataBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ReferenceViewHolder, position: Int) {
        val learning: Learning = list[position]
        holder.title.text = learning.title
        holder.itemView.setOnClickListener{
            onClickItem?.invoke(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    inner class ReferenceViewHolder(binding:ItemFbDataBinding): RecyclerView.ViewHolder(binding.root){
        val title: TextView = binding.tvTitle

    }
}
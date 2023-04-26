package com.example.workout_exercise_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workout_exercise_app.databinding.SholderItemsBinding
import com.example.workout_exercise_app.modal.Sholder

class SholderAdapter(val SholderList : List<Sholder>) : RecyclerView.Adapter<SholderAdapter.SholderViewHolder>() {

    private lateinit var binding : SholderItemsBinding
    var onItemClick : ((Sholder) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SholderAdapter.SholderViewHolder {
        return SholderViewHolder(SholderItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: SholderAdapter.SholderViewHolder, position: Int) {
       val sholder = SholderList[position]
        holder.bind(sholder)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(sholder)
        }
    }

    override fun getItemCount(): Int {
        return SholderList.size
    }

    inner class SholderViewHolder(val binding: SholderItemsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(sholder: Sholder){
            binding.sldrimv.setImageResource(sholder.image)
            binding.sldrtv.text = sholder.name
        }
    }
}
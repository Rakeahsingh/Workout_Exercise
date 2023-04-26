package com.example.workout_exercise_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workout_exercise_app.databinding.BackItemsBinding
import com.example.workout_exercise_app.modal.Back

class BackAdapter(val BackList : List<Back>) : RecyclerView.Adapter<BackAdapter.BackViewHolder>() {

    private lateinit var binding : BackItemsBinding
    var onItemClick : ((Back) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BackAdapter.BackViewHolder {
        return BackViewHolder(BackItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: BackAdapter.BackViewHolder, position: Int) {
        val back = BackList[position]
        holder.bind(back)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(back)
        }
    }

    override fun getItemCount(): Int {
        return BackList.size
    }

    inner class BackViewHolder(val binding: BackItemsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(back: Back){
            binding.bckimv.setImageResource(back.Image)
            binding.bcktv.text = back.name
        }
    }
}
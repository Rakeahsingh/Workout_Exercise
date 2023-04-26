package com.example.workout_exercise_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workout_exercise_app.databinding.AbsItemBinding
import com.example.workout_exercise_app.modal.Abs
import com.example.workout_exercise_app.modal.Exercise

class AbsAdapter(val AbsList : List<Abs>) : RecyclerView.Adapter<AbsAdapter.AbsViewHolder>() {

    private lateinit var binding: AbsItemBinding

    var onItemClick : ((Abs)-> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbsAdapter.AbsViewHolder {
        return AbsViewHolder(AbsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: AbsAdapter.AbsViewHolder, position: Int) {
        val abs = AbsList[position]
        holder.bind(abs)
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(abs)
        }

    }

    override fun getItemCount(): Int {
        return AbsList.size
    }

    inner class AbsViewHolder(val binding: AbsItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(abs: Abs){
            binding.absimv.setImageResource(abs.Image)
            binding.abstv.text = abs.name
        }
    }
}
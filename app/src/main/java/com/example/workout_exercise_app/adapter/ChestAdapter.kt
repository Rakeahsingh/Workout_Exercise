package com.example.workout_exercise_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workout_exercise_app.databinding.ChestItemBinding
import com.example.workout_exercise_app.modal.Abs
import com.example.workout_exercise_app.modal.Chest

class ChestAdapter( val ChestList : List<Chest>) : RecyclerView.Adapter<ChestAdapter.ChestViewHolder>() {

    private lateinit var binding: ChestItemBinding

    var onItemClick : ((Chest)-> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChestAdapter.ChestViewHolder {
        return ChestViewHolder(ChestItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ChestAdapter.ChestViewHolder, position: Int) {
        val chest = ChestList[position]
        holder.bind(chest)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(chest)
        }
    }

    override fun getItemCount(): Int {
        return ChestList.size
    }

    inner class ChestViewHolder(val binding: ChestItemBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(chest: Chest){
            binding.chtimv.setImageResource(chest.Image)
            binding.chttv.text = chest.name
        }
    }
}
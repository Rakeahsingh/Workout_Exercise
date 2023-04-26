package com.example.workout_exercise_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workout_exercise_app.databinding.LegItemsBinding
import com.example.workout_exercise_app.modal.Leg

class LegAdapter(val LegList : List<Leg>) : RecyclerView.Adapter<LegAdapter.LegViewHolder>(){

    private lateinit var binding : LegItemsBinding
    var onItemClick : ((Leg) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LegAdapter.LegViewHolder {
        return LegViewHolder(LegItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: LegAdapter.LegViewHolder, position: Int) {
       val leg = LegList[position]
        holder.bind(leg)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(leg)
        }
    }

    override fun getItemCount(): Int {
       return LegList.size
    }

    inner class LegViewHolder(val binding: LegItemsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(leg: Leg){
            binding.legimv.setImageResource(leg.Image)
            binding.legstv.text = leg.name
        }
    }
}
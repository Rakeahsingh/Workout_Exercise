package com.example.workout_exercise_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workout_exercise_app.databinding.BicepsItemsBinding
import com.example.workout_exercise_app.modal.Biceps

class BicepsAdapter(val BicepsList : List<Biceps>) : RecyclerView.Adapter<BicepsAdapter.BicepsViewHolder>() {

    private lateinit var binding: BicepsItemsBinding

    var onItemClick : ((Biceps) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BicepsAdapter.BicepsViewHolder {
       return BicepsViewHolder(BicepsItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: BicepsAdapter.BicepsViewHolder, position: Int) {
        val biceps = BicepsList[position]
        holder.bind(biceps)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(biceps)
        }
    }

    override fun getItemCount(): Int {
        return BicepsList.size
    }

    inner class BicepsViewHolder(val binding: BicepsItemsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(biceps: Biceps){
            binding.bcpsimv.setImageResource(biceps.Image)
            binding.bcpstv.text = biceps.name
        }
    }
}
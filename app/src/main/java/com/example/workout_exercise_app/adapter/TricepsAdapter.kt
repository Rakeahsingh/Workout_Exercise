package com.example.workout_exercise_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workout_exercise_app.modal.Triceps
import com.example.workout_exercise_app.databinding.TricepsItemsBinding

class TricepsAdapter(val TricepsList : List<Triceps>) : RecyclerView.Adapter<TricepsAdapter.TricepsViewHolder>() {

    private lateinit var binding: TricepsItemsBinding
     var onItemClick : ((Triceps) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TricepsAdapter.TricepsViewHolder {
        return TricepsViewHolder(TricepsItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TricepsAdapter.TricepsViewHolder, position: Int) {
        val triceps = TricepsList[position]
        holder.bind(triceps)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(triceps)
        }
    }

    override fun getItemCount(): Int {
        return TricepsList.size
    }

    inner class TricepsViewHolder(val binding: TricepsItemsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(triceps: Triceps){
            binding.tcpsimv.setImageResource(triceps.Image)
            binding.tcpstv.text = triceps.name
        }
    }
}
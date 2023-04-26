package com.example.workout_exercise_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workout_exercise_app.databinding.ExerciseItemsBinding
import com.example.workout_exercise_app.modal.Exercise

class ExerciseAdapter(val ExerciseList : List<Exercise>) : RecyclerView.Adapter<ExerciseAdapter.ExerciseviewHolder>() {

    private lateinit var binding: ExerciseItemsBinding

    var onItemClick : ((Exercise) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseAdapter.ExerciseviewHolder {
        return ExerciseviewHolder(ExerciseItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ExerciseAdapter.ExerciseviewHolder, position: Int) {
        val exercise = ExerciseList[position]
        holder.bindItem(exercise)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(exercise)
        }

    }

    override fun getItemCount(): Int {
        return ExerciseList.size
    }

    inner class ExerciseviewHolder(val binding: ExerciseItemsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindItem(exercise: Exercise){
            binding.eximv.setImageResource(exercise.Image)
            binding.extv.text = exercise.name
        }

    }
}
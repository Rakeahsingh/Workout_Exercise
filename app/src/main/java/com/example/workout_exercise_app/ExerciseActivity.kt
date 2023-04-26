package com.example.workout_exercise_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.workout_exercise_app.ABSActivity.ABSActivity
import com.example.workout_exercise_app.BackActivity.Back
import com.example.workout_exercise_app.BicepsActivity.Biceps
import com.example.workout_exercise_app.CHESTActivity.Chest
import com.example.workout_exercise_app.LegActivity.Leg
import com.example.workout_exercise_app.Objects.ExerciseList
import com.example.workout_exercise_app.TricepsActivity.Triceps
import com.example.workout_exercise_app.adapter.ExerciseAdapter
import com.example.workout_exercise_app.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExerciseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val adapter = ExerciseAdapter(ExerciseList.ExerciseList)
        binding.exrv.adapter = adapter

        adapter.onItemClick = {
            when(it.Image){
                R.drawable.img_1 -> { val intent = Intent(this, ABSActivity::class.java)
                                        startActivity(intent)}
                R.drawable.img_2 -> {val intent = Intent(this, Chest::class.java)
                                        startActivity(intent)}
                R.drawable.img_3 -> {val intent = Intent(this, Biceps::class.java)
                                           startActivity(intent)}
                R.drawable.img_4 -> {val intent = Intent(this, Triceps::class.java)
                                          startActivity(intent)}
                R.drawable.img -> {val intent = Intent(this, Leg::class.java)
                                         startActivity(intent)}
                R.drawable.img_6 -> {val intent = Intent(this, Back::class.java)
                                          startActivity(intent)}
                R.drawable.img_7 -> {val intent = Intent(this, Sholder::class.java)
                                          startActivity(intent)}
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding != null
    }
}
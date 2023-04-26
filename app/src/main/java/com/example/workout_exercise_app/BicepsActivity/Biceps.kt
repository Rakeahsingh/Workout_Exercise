package com.example.workout_exercise_app.BicepsActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.workout_exercise_app.Objects.BicepsList
import com.example.workout_exercise_app.adapter.BicepsAdapter
import com.example.workout_exercise_app.databinding.ActivityBicepsBinding

class Biceps : AppCompatActivity() {

    private lateinit var binding: ActivityBicepsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBicepsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = BicepsAdapter(BicepsList.BicepsList)
        binding.bcpsrv.adapter = adapter

        adapter.onItemClick = {
            val intent = Intent(this, FinalBiceps::class.java)
            intent.putExtra("Biceps",it)
            startActivity(intent)
        }
    }
}
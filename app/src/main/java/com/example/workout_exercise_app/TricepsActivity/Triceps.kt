package com.example.workout_exercise_app.TricepsActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.workout_exercise_app.Objects.TricepsList
import com.example.workout_exercise_app.adapter.TricepsAdapter
import com.example.workout_exercise_app.databinding.ActivityTricepsBinding

class Triceps : AppCompatActivity() {

    private lateinit var binding: ActivityTricepsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTricepsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = TricepsAdapter(TricepsList.TricepsList)
        binding.tcpsrv.adapter = adapter

        adapter.onItemClick = {
            val intent = Intent(this, FinalTriceps::class.java)
            intent.putExtra("Triceps",it)
            startActivity(intent)
        }
    }
}
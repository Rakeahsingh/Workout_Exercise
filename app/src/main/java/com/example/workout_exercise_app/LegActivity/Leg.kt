package com.example.workout_exercise_app.LegActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.workout_exercise_app.Objects.LegList
import com.example.workout_exercise_app.adapter.LegAdapter
import com.example.workout_exercise_app.databinding.ActivityLegBinding

class Leg : AppCompatActivity() {

    private lateinit var binding : ActivityLegBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLegBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = LegAdapter(LegList.LegList)
        binding.legsrv.adapter = adapter

        adapter.onItemClick = {
            val intent = Intent(this, FinalLeg::class.java)
            intent.putExtra("Leg",it)
            startActivity(intent)
        }
    }
}
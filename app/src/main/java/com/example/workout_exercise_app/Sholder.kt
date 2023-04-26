package com.example.workout_exercise_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.workout_exercise_app.Objects.SholderList
import com.example.workout_exercise_app.adapter.SholderAdapter
import com.example.workout_exercise_app.databinding.ActivitySholderBinding

class Sholder : AppCompatActivity() {

    private lateinit var binding : ActivitySholderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySholderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = SholderAdapter(SholderList.SholderList)
        binding.sldrrv.adapter = adapter

        adapter.onItemClick = {
            val intent = Intent(this,FinalSholder::class.java)
            intent.putExtra("Sholder",it)
            startActivity(intent)
        }
    }
}
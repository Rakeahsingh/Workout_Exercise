package com.example.workout_exercise_app.BackActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.workout_exercise_app.Objects.BackList
import com.example.workout_exercise_app.adapter.BackAdapter
import com.example.workout_exercise_app.databinding.ActivityBackBinding

class Back : AppCompatActivity() {

    private lateinit var binding : ActivityBackBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = BackAdapter(BackList.BackList)
        binding.bcksrv.adapter = adapter

        adapter.onItemClick = {
            val intent = Intent(this, FinalBack::class.java)
            intent.putExtra("Back",it)
            startActivity(intent)
        }
    }
}
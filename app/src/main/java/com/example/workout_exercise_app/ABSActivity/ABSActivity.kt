package com.example.workout_exercise_app.ABSActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.workout_exercise_app.Objects.AbsList
import com.example.workout_exercise_app.adapter.AbsAdapter
import com.example.workout_exercise_app.databinding.ActivityAbsactivityBinding

class ABSActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAbsactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAbsactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = AbsAdapter(AbsList.AbsList)
        binding.absrv.adapter = adapter


        adapter.onItemClick = {
            val intent = Intent(this, FinalAbs::class.java)
            intent.putExtra("Abs",it)
            startActivity(intent)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding != null
    }
}
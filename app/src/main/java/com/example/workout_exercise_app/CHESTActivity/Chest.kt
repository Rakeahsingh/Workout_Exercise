package com.example.workout_exercise_app.CHESTActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.workout_exercise_app.Objects.ChestList
import com.example.workout_exercise_app.adapter.ChestAdapter
import com.example.workout_exercise_app.databinding.ActivityChestBinding

class Chest : AppCompatActivity() {

    private lateinit var binding: ActivityChestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ChestAdapter(ChestList.ChestList)
        binding.chtrv.adapter = adapter

        adapter.onItemClick = {
            val intent = Intent(this, FinalChest::class.java)
            intent.putExtra("Chest",it)
            startActivity(intent)
        }
    }
}
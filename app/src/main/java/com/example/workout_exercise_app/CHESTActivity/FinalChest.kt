package com.example.workout_exercise_app.CHESTActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.example.workout_exercise_app.databinding.ActivityFinalChestBinding
import com.example.workout_exercise_app.modal.Abs
import com.example.workout_exercise_app.modal.Chest

class FinalChest : AppCompatActivity() {

    private lateinit var binding: ActivityFinalChestBinding

    private var restTimer : CountDownTimer? = null
    private var restProgress = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalChestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRestView()

        val Chest = intent.getParcelableExtra<Chest>("Chest")
        if (Chest != null){
            binding.chtimgv.setImageResource(Chest.Image)
            binding.chttv.text = Chest.name
        }
    }

    private fun setupRestView(){
        if (restTimer != null){
            restTimer?.cancel()
            restProgress = 0
        }
        setRestProgressBar()
    }

    private fun setRestProgressBar(){
        binding.chtprogress.progress = restProgress

        restTimer = object : CountDownTimer(120000,1000){
            override fun onTick(p0: Long) {
                restProgress++
                binding.chtprogress.progress = 120 - restProgress
                binding.tvtimer.text = (120 - restProgress).toString()
            }

            override fun onFinish() {
                Toast.makeText(this@FinalChest, "Exercise completed", Toast.LENGTH_SHORT).show()
            }

        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (restTimer != null){
            restTimer?.cancel()
            restProgress = 0
        }
        binding != null
    }
}
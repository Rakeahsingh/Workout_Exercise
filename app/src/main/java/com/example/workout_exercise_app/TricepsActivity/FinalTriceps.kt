package com.example.workout_exercise_app.TricepsActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.example.workout_exercise_app.databinding.ActivityFinalTricepsBinding
import com.example.workout_exercise_app.modal.Triceps

class FinalTriceps : AppCompatActivity() {

    private lateinit var binding : ActivityFinalTricepsBinding
    private var restTimer : CountDownTimer? = null
    private var restProgress = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalTricepsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRestView()

        val Triceps = intent.getParcelableExtra<Triceps>("Triceps")
        if (Triceps != null){
            binding.frmimgv.setImageResource(Triceps.Image)
            binding.fltv.text = Triceps.name
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
        binding.progress.progress = restProgress

        restTimer = object : CountDownTimer(120000,1000){
            override fun onTick(p0: Long) {
                restProgress++
                binding.progress.progress = 120 - restProgress
                binding.tvtimer.text = (120 - restProgress).toString()
            }

            override fun onFinish() {
                Toast.makeText(this@FinalTriceps, "Exercise completed", Toast.LENGTH_SHORT).show()
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
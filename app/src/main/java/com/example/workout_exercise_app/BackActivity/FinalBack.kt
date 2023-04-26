package com.example.workout_exercise_app.BackActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.example.workout_exercise_app.databinding.ActivityFinalBackBinding
import com.example.workout_exercise_app.modal.Back

class FinalBack : AppCompatActivity() {

    private lateinit var binding : ActivityFinalBackBinding
    private var restTimer : CountDownTimer? = null
    private var restProgress = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalBackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRestView()

        val Back = intent.getParcelableExtra<Back>("Back")
        if (Back != null){
            binding.frmimgv.setImageResource(Back.Image)
            binding.fltv.text = Back.name
        }
    }

    private fun setUpRestView(){
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
                binding.tvtimer.text = (120-restProgress).toString()
            }

            override fun onFinish() {
                Toast.makeText(this@FinalBack, "Exercise completed", Toast.LENGTH_SHORT).show()
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
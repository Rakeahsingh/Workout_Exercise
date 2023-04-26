package com.example.workout_exercise_app.BicepsActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.example.workout_exercise_app.databinding.ActivityFinalBicepsBinding
import com.example.workout_exercise_app.modal.Biceps

class FinalBiceps : AppCompatActivity() {

    private lateinit var binding : ActivityFinalBicepsBinding

    private var restTimer : CountDownTimer? = null
    private var restProgress = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalBicepsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRestView()

        val Biceps = intent.getParcelableExtra<Biceps>("Biceps")
        if (Biceps != null){
            binding.frmimgv.setImageResource(Biceps.Image)
            binding.fltv.text = Biceps.name
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
                Toast.makeText(this@FinalBiceps, "Exercise completed", Toast.LENGTH_SHORT).show()
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
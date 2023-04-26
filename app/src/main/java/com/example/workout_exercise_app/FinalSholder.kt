package com.example.workout_exercise_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.example.workout_exercise_app.databinding.ActivityFinalSholderBinding
import com.example.workout_exercise_app.modal.Sholder

class FinalSholder : AppCompatActivity() {

    private lateinit var binding : ActivityFinalSholderBinding
    private var restTimer : CountDownTimer? = null
    private var restProgress = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalSholderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRestView()

        val Sholder = intent.getParcelableExtra<Sholder>("Sholder")
        if (Sholder != null){
            binding.frmimgv.setImageResource(Sholder.image)
            binding.fltv.text = Sholder.name
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
                Toast.makeText(this@FinalSholder, "Exercise completed", Toast.LENGTH_SHORT).show()
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
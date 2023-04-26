package com.example.workout_exercise_app.ABSActivity

import android.media.Image
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.example.workout_exercise_app.databinding.ActivityFinalAbsBinding
import com.example.workout_exercise_app.modal.Abs

class FinalAbs : AppCompatActivity() {

    private lateinit var binding: ActivityFinalAbsBinding

    private var restTimer : CountDownTimer? = null
    private var restProgrss = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalAbsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRestView()

       val Abs = intent.getParcelableExtra<Abs>("Abs")
        if (Abs != null){
            binding.frmimgv.setImageResource(Abs.Image)
            binding.fltv.text = Abs.name
        }
    }

    private fun setupRestView(){
        if (restTimer != null){
            restTimer?.cancel()
            restProgrss = 0
        }

        setRestProgessBar()
    }

    private fun setRestProgessBar(){
        binding.progress.progress = restProgrss

        restTimer = object : CountDownTimer(30000,1000){
            override fun onTick(p0: Long) {
                restProgrss++
                binding.progress.progress = 30 - restProgrss
                binding.tvtimer.text = (30 - restProgrss).toString()
            }

            override fun onFinish() {
                Toast.makeText(this@FinalAbs, "Exercise Completed", Toast.LENGTH_SHORT).show()
            }

        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (restTimer != null){
            restTimer?.cancel()
            restProgrss = 0
        }
        binding != null
    }

}
package com.example.stopwatch

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import java.util.Locale

class MainActivity : ComponentActivity() {

    private var seconds = 0
    private var running = false
    private var wasRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds")
            running = savedInstanceState.getBoolean("running")
            wasRunning = savedInstanceState.getBoolean("wasRunning")
        }

        runTimer()

        val startButton: Button = findViewById(R.id.buttonStart)
        val stopButton: Button = findViewById(R.id.buttonStop)
        val resetButton: Button = findViewById(R.id.buttonReset)

        startButton.setOnClickListener {
            running = true
        }

        stopButton.setOnClickListener {
            running = false
        }

        resetButton.setOnClickListener {
            running = false
            seconds = 0
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("seconds", seconds)
        outState.putBoolean("running", running)
        outState.putBoolean("wasRunning", wasRunning)
    }

    override fun onPause() {
        super.onPause()
        wasRunning = running
        running = false
    }

    override fun onResume() {
        super.onResume()
        if (wasRunning) {
            running = true
        }
    }

    private fun runTimer() {
        val timeView: TextView = findViewById(R.id.textViewTime)
        val handler = Handler(Looper.getMainLooper())
        handler.post(object : Runnable {
            override fun run() {
                val hours = seconds / 3600
                val minutes = (seconds % 3600) / 60
                val secs = seconds % 60
                val time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs)
                timeView.text = time
                if (running) {
                    seconds++
                }
                handler.postDelayed(this, 1000)
            }
        })
    }
}

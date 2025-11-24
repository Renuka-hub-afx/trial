package com.example.trial

import android.content.Intent
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Apply the gradient effect to the "SWASTHYAMITRA" text
        applyGradientToText()

        // 1. Find the button by its ID
        val startButton = findViewById<Button>(R.id.button_start)

        // 2. Set the click listener
        startButton.setOnClickListener {
            // Create an Intent to navigate to NextActivity
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
        }
    }

    // Function to apply the gradient to the "SWASTHYAMITRA" TextView
    private fun applyGradientToText() {
        val appNameTextView = findViewById<TextView>(R.id.text_app_name)

        val gradientColors = intArrayOf(
            ContextCompat.getColor(this, R.color.text_gradient_start),
            ContextCompat.getColor(this, R.color.text_gradient_middle),
            ContextCompat.getColor(this, R.color.text_gradient_end)
        )

        appNameTextView.post {
            val textWidth = appNameTextView.measuredWidth.toFloat()
            val textHeight = appNameTextView.textSize

            val shader = LinearGradient(
                0f, 0f, textWidth, textHeight,
                gradientColors,
                null,
                Shader.TileMode.CLAMP
            )
            appNameTextView.paint.shader = shader
            appNameTextView.invalidate()
        }
    }
}
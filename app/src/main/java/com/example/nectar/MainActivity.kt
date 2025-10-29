package com.example.yourapp // Change to your package name

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.nectar.R
import com.example.nectar.databinding.OnbordingBinding

class SplashActivity : AppCompatActivity() {

    private val SPLASH_DELAY: Long = 1500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)


        supportActionBar?.hide()


        Handler(Looper.getMainLooper()).postDelayed({
            navigateToMainActivity()
        }, SPLASH_DELAY)
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, OnbordingBinding::class.java)
        startActivity(intent)
        finish()
    }

    override fun onBackPressed() {
    }
}
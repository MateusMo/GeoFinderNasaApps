package com.example.geofinder.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.geofinder.R

class AboutGeologyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_geology)

        val backButton = findViewById<ImageButton>(R.id.button_arrowback2)

        backButton.setOnClickListener {
            // Criar um intent para retornar à tela inicial
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}
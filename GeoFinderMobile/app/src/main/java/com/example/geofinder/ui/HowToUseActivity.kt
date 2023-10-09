package com.example.geofinder.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.geofinder.R

class HowToUseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_to_use)

        val backButton = findViewById<ImageButton>(R.id.button_arrowback)

        backButton.setOnClickListener {
            // Criar um intent para retornar à tela inicial
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}
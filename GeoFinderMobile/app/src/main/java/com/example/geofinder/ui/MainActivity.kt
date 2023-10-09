package com.example.geofinder.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.geofinder.R
import com.example.geofinder.data.LocationViewModel
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var locationViewModel: LocationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialize o ViewModel
        locationViewModel = ViewModelProvider(this).get(LocationViewModel::class.java)

        val menuButton = findViewById<ImageButton>(R.id.button_menu)
        val buttonFinder = findViewById<Button>(R.id.button_finder)
        val editTextLatitude = findViewById<EditText>(R.id.et_latitude)
        val editTextLongitude = findViewById<EditText>(R.id.et_longitude)
        val editTextZoom = findViewById<EditText>(R.id.et_zoom)
        val buttonGenerate = findViewById<Button>(R.id.button_generatelocation)

        buttonGenerate.setOnClickListener {
            // Gerar valores aleatórios
            val randomLatitude = Random.nextDouble(-90.0, 90.0)
            val randomLongitude = Random.nextDouble(-180.0, 180.0)
            val randomZoom = Random.nextInt(2, 23)

            // Formatar os valores com até 4 casas decimais
            val formattedLatitude = String.format("%.4f", randomLatitude)
            val formattedLongitude = String.format("%.4f", randomLongitude)

            // Preencher os campos de entrada com os valores formatados
            editTextLatitude.setText(formattedLatitude)
            editTextLongitude.setText(formattedLongitude)
            editTextZoom.setText(randomZoom.toString())
        }

        menuButton.setOnClickListener { view ->
            val popupMenu = PopupMenu(this, view)
            val inflater: MenuInflater = popupMenu.menuInflater
            inflater.inflate(R.menu.menu_options, popupMenu.menu)

            popupMenu.setOnMenuItemClickListener { item: MenuItem ->
                when (item.itemId) {
                    R.id.menu_option_1 -> {
                        // Lógica para "How to use this app"
                        val intent = Intent(this, HowToUseActivity::class.java)
                        startActivity(intent)
                        true
                    }

                    R.id.menu_option_2 -> {
                        // Lógica para "Quizzes"
                        val intent = Intent(this, QuizzesActivity::class.java)
                        startActivity(intent)
                        true
                    }

                    R.id.menu_option_3 -> {
                        // Lógica para "About Geology"
                        val intent = Intent(this, AboutGeologyActivity::class.java)
                        startActivity(intent)
                        true
                    }

                    else -> false
                }
            }
            popupMenu.show()
        }

        buttonFinder.setOnClickListener {

                val latitudeText = editTextLatitude.text.toString()
                val longitudeText = editTextLongitude.text.toString()
                val zoomText = editTextZoom.text.toString()

                if (isValidInput(latitudeText) && isValidInput(longitudeText) && isValidZoom(zoomText)) {

                    // Preencha os valores no ViewModel
                    locationViewModel.latitude = latitudeText.toDouble()
                    locationViewModel.longitude = longitudeText.toDouble()
                    locationViewModel.zoom = zoomText.toInt()

                    // Faça a solicitação HTTP POST
                    locationViewModel.makeHttpPostRequest()

                    // Os campos estão preenchidos corretamente, inicie a atividade ViewLocationActivity
                    val intent = Intent(this, ViewLocationActivity::class.java)
                    startActivity(intent)
                } else {
                    // Exibir uma mensagem de erro ao usuário ou tomar outra ação adequada
                    // Por exemplo, mostrar uma mensagem Toast
                    Toast.makeText(this, "Preencha os campos corretamente.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        private fun isValidInput(input: String): Boolean {
            // Valide se a entrada é um número decimal válido
            return try {
                val number = input.toDouble()
                true
            } catch (e: NumberFormatException) {
                false
            }
        }

        private fun isValidZoom(zoomText: String): Boolean {
            // Valide se o zoom está dentro do intervalo válido (2 a 22)
            return try {
                val zoom = zoomText.toInt()
                zoom in 2..22
            } catch (e: NumberFormatException) {
                false
            }
        }

}


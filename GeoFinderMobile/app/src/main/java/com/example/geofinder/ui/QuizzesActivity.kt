package com.example.geofinder.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.geofinder.R
import com.example.geofinder.data.QuestionsData


class QuizzesActivity : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var option1Button: Button
    private lateinit var option2Button: Button
    private lateinit var option3Button: Button
    private lateinit var option4Button: Button
    private lateinit var nextButton: Button


    private var questionsList = mutableListOf(
        QuestionsData("What is geology?", listOf("The study of Earth's history, structure, and processes.", "The study of celestial bodies like stars and planets.", "The study of human societies and cultures.", "The study of the weather and climate."), 0),
        QuestionsData("What is the Earth's outermost layer called?", listOf("Mantle", "Crust", "Core", "Hydrosphere"), 1),
        QuestionsData("Which continent is known for having a large portion covered by ice?", listOf("South America", "Europe", "Antarctica", "Asia"), 2),
        QuestionsData("What is the latitude of the North Pole?", listOf("0 degrees", "90 degrees North", "23.5 degrees North", "66.5 degrees North"), 1),
        QuestionsData("Who studies and works in the field of geology?", listOf("Meteorologists", "Geologists", "Biologists", "Astronomers"), 1),
        QuestionsData("What are the major layers of the Earth's interior, in order from the outermost to the innermost?", listOf("Crust, Mantle, Core", "Core, Mantle, Crust", "Mantle, Core, Crust", "Crust, Core, Mantle"), 0),
        QuestionsData("What is the longitude of the Prime Meridian?", listOf("0 degrees", "90 degrees East", "180 degrees", "45 degrees West"), 0),
        QuestionsData("What type of rock is formed from the cooling and solidification of molten lava?", listOf("Sedimentary rock", "Metamorphic rock", "Igneous rock", "Fossilized rock"), 2),
        QuestionsData("Which geological event is responsible for the formation of mountains?", listOf("Erosion", "Volcanic eruptions", "Tectonic plate movements", "Earthquakes"), 2),
        QuestionsData("What do geologists use to determine the age of rocks and fossils?", listOf("Radiocarbon dating", "Tree rings", "Ice cores", "GPS coordinates"), 0),
        QuestionsData("What is the process by which rocks are broken down into smaller pieces by wind, water, and other natural forces?", listOf("Sedimentation", "Erosion", "Volcanism", "Subduction"), 1),
        QuestionsData("Which type of rock forms from the alteration of existing rock through heat, pressure, or mineral exchange?", listOf("Igneous rock", "Sedimentary rock", "Metamorphic rock", "Fossilized rock"), 2),
        QuestionsData("What is the term for the point on the Earth's surface directly above the earthquake's origin?", listOf("Epicenter", "Crust", "Fault", "Mantle"), 0),
        QuestionsData("Which mineral is the hardest known natural material on Earth?", listOf("Quartz", "Diamond", "Feldspar", "Calcite"), 1),
        QuestionsData("What is the term for a sudden release of energy in the Earth's crust that causes seismic waves?", listOf("Volcano", "Avalanche", "Tornado", "Earthquake"), 3),
        QuestionsData("What type of volcano is characterized by gentle, sloping sides and tends to erupt non-explosively?", listOf("Stratovolcano", "Shield volcano", "Cinder cone volcano", "Caldera"), 1),
        QuestionsData("Which geological era is often referred to as the 'Age of Dinosaurs'?", listOf("Paleozoic Era", "Cenozoic Era", "Mesozoic Era", "Precambrian Era"), 2),
        QuestionsData("What is the name of the supercontinent that existed more than 300 million years ago and later broke apart into today's continents?", listOf("Gondwana", "Pangaea", "Laurasia", "Euramerica"), 1),
        QuestionsData("What is the process of soil being carried away by wind or water?", listOf("Desiccation", "Leaching", "Erosion", "Deposition"), 2),
        QuestionsData("What is the name for a naturally occurring, solid substance composed of minerals?", listOf("Rock", "Mineral", "Ore", "Crystal"), 0)
        // Add more questions here
    )

    private var currentQuestionIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizzes)

        val backButton = findViewById<ImageButton>(R.id.button_arrowback3)

        backButton.setOnClickListener {
            // Criar um intent para retornar à tela inicial
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        questionsList.shuffle()

        questionTextView = findViewById(R.id.questionTextView)
        option1Button = findViewById(R.id.option1Button)
        option2Button = findViewById(R.id.option2Button)
        option3Button = findViewById(R.id.option3Button)
        option4Button = findViewById(R.id.option4Button)
        nextButton = findViewById(R.id.nextButton)

        displayQuestion()

        option1Button.setOnClickListener {
            checkAnswer(0)
        }

        option2Button.setOnClickListener {
            checkAnswer(1)
        }

        option3Button.setOnClickListener {
            checkAnswer(2)
        }

        option4Button.setOnClickListener {
            checkAnswer(3)
        }

        nextButton.setOnClickListener {
            if (currentQuestionIndex < questionsList.size - 1) {
                currentQuestionIndex++
                displayQuestion()
            } else {
                Toast.makeText(this, "Quiz completed!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun displayQuestion() {
        val currentQuestion = questionsList[currentQuestionIndex]
        questionTextView.text = currentQuestion.questionText
        option1Button.text = currentQuestion.options[0]
        option2Button.text = currentQuestion.options[1]
        option3Button.text = currentQuestion.options[2]
        option4Button.text = currentQuestion.options[3]

        // Reset button visibility
        nextButton.visibility = View.GONE
    }

    private fun checkAnswer(selectedOption: Int) {
        val currentQuestion = questionsList[currentQuestionIndex]
        if (selectedOption == currentQuestion.correctAnswer) {
            showToast("Correct!")
        } else {
            showToast("Wrong! The correct answer is: ${currentQuestion.options[currentQuestion.correctAnswer]}")
        }

        // Show the Next Question button
        nextButton.visibility = View.VISIBLE
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    }

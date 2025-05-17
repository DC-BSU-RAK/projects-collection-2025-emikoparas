package com.example.moodcalcu

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var moodSpinner: Spinner
    private lateinit var calculateButton: Button
    private lateinit var responseText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moodSpinner = findViewById(R.id.moodSpinner)
        calculateButton = findViewById(R.id.calculateButton)
        responseText = findViewById(R.id.responseText)

        // Setup mood options
        val moods = resources.getStringArray(R.array.mood_options)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, moods)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        moodSpinner.adapter = adapter

        calculateButton.setOnClickListener {
            val selectedMood = moodSpinner.selectedItem.toString()
            val message = when {
                selectedMood.contains("Happy") -> "You're feeling great! 🌞\n\n\"Happiness is a journey, not a destination.\""
                selectedMood.contains("Sad") -> "It's okay to feel sad. 💙\n\n\"Tears are words the heart can't say.\""
                selectedMood.contains("Angry") -> "Take a deep breath. 🧘\n\n\"Speak when you’re angry and you’ll make the best speech you’ll ever regret.\""
                selectedMood.contains("Calm") -> "You're at peace. 🌿\n\n\"Calm mind brings inner strength.\""
                selectedMood.contains("Anxious") -> "You're not alone. 🤍\n\n\"You don’t have to control your thoughts. You just have to stop letting them control you.\""
                else -> "Please select a mood."
            }
            responseText.text = message
        }
    }
}

package com.example.lab_week_01

import android.os.Bundle
import android.view.Gravity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameDisplay = findViewById<TextView>(R.id.name_display)
        val studentNumberDisplay = findViewById<TextView>(R.id.student_number_display)
        val nameSubmit = findViewById<Button>(R.id.name_submit)

        nameSubmit.setOnClickListener {
            val nameInput = findViewById<TextInputEditText>(R.id.name_input)?.text.toString().trim()
            val studentNumberInput = findViewById<TextInputEditText>(R.id.student_number_input)?.text.toString().trim()

            var isValid = true

            if (nameInput.isEmpty()) {
                Toast.makeText(this, getString(R.string.name_empty), Toast.LENGTH_LONG)
                    .apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
                isValid = false
            }

            if (studentNumberInput.length != 11) {
                Toast.makeText(this, "Student number has to be 11 digits long", Toast.LENGTH_LONG)
                    .apply {
                        setGravity(Gravity.CENTER, 0, 0)
                        show()
                    }
                isValid = false
            }

            if (isValid) {
                nameDisplay?.text = getString(R.string.name_greet).plus(" ").plus(nameInput)
                studentNumberDisplay?.text = "Student Number: $studentNumberInput"
            }
        }
    }
}
package com.example.registrationapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val firstName = intent.getStringExtra("firstName") ?: "N/A"
        val lastName = intent.getStringExtra("lastName") ?: "N/A"
        val mobile = intent.getStringExtra("mobile") ?: "N/A"

        val tvSummary = findViewById<TextView>(R.id.tvSummary)
        tvSummary.text = "Name: $firstName $lastName\nMobile: $mobile"
    }
}

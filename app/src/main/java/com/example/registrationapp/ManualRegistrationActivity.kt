package com.example.registrationapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ManualRegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manual_registration)

        val etFirstName = findViewById<EditText>(R.id.etFirstName)
        val etLastName = findViewById<EditText>(R.id.etLastName)
        val etMobile = findViewById<EditText>(R.id.etMobile)
        val btnProceed = findViewById<Button>(R.id.btnProceed)

        btnProceed.setOnClickListener {
            val intent = Intent(this, SummaryActivity::class.java)
            intent.putExtra("firstName", etFirstName.text.toString())
            intent.putExtra("lastName", etLastName.text.toString())
            intent.putExtra("mobile", etMobile.text.toString())
            startActivity(intent)
        }
    }
}

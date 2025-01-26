package com.example.registrationapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

import com.truecaller.android.sdk.TruecallerSDK
import com.truecaller.android.sdk.TruecallerSdkScope

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manualRegBtn = findViewById<Button>(R.id.btnManualRegistration)
        val truecallerRegBtn = findViewById<Button>(R.id.btnOneClickRegistration)

        // Initialize Truecaller SDK
        val sdkScope = TruecallerSdkScope.Builder(this, object : TruecallerSdkScope.Callback() {
            override fun onSuccess(profile: TruecallerSdkScope.Profile) {
                val intent = Intent(this@MainActivity, SummaryActivity::class.java)
                intent.putExtra("firstName", profile.firstName)
                intent.putExtra("lastName", profile.lastName)
                intent.putExtra("mobile", profile.phoneNumber)
                startActivity(intent)
            }

            override fun onFailure(error: TruecallerSdkScope.ErrorType) {
                // Handle failure
            }
        })
            .consentMode(TruecallerSdkScope.CONSENT_MODE_POPUP)
            .loginMode(TruecallerSdkScope.SDK_LOGIN_FLAG)
            .sdkKey("QJPTHd94ab0db541b41b4ab88211ba12f8000")
            .build()

        TruecallerSDK.init(sdkScope)

        // Manual Registration Flow
        manualRegBtn.setOnClickListener {
            val intent = Intent(this, ManualRegistrationActivity::class.java)
            startActivity(intent)
        }

        // Truecaller Registration Flow
        truecallerRegBtn.setOnClickListener {
            if (TruecallerSDK.getInstance().isUsable) {
                TruecallerSDK.getInstance().getUserProfile(this)
            }
        }
    }
}

package com.marvel.characters.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.marvel.characters.R
import com.marvel.characters.ui.activity.MainActivity

class LandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }
        Firebase.remoteConfig.apply {
            setConfigSettingsAsync(configSettings)
            setDefaultsAsync(R.xml.remote_config)
            fetchAndActivate().addOnCompleteListener {
                redirect()
            }
        }
    }


    private fun redirect(){
        startActivity(Intent(this, MainActivity::class.java))
    }
}
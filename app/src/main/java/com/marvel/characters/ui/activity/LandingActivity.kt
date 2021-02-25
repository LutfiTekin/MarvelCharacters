package com.marvel.characters.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.marvel.characters.R

/**
 * This activity created for app initialization and splash screen purposes
 */
class LandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)
        fetchRemoteConfigAndRedirect()
    }

    /**
     * Fetch marvel public and private key from firebase remote config
     */
    private fun fetchRemoteConfigAndRedirect() {
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }
        Firebase.remoteConfig.apply {
            setConfigSettingsAsync(configSettings)
            setDefaultsAsync(R.xml.remote_config)
            fetchAndActivate().addOnCompleteListener {
                startActivity(Intent(this@LandingActivity, MainActivity::class.java))
            }
        }
    }

}
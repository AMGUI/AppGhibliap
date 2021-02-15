package com.example.etudiodibri.Activity

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.etudiodibri.R
 private lateinit var mIntroGhibli : MediaPlayer
 private val SPLASH_TIME_OUT:Long = 7000
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mIntroGhibli = MediaPlayer.create(applicationContext,R.raw.intrighibli)
        mIntroGhibli.start()

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        },   SPLASH_TIME_OUT )


    }
}
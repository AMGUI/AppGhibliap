package com.example.etudiodibri.activity.splash

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.etudiodibri.MainActivity
import com.example.etudiodibri.R

class SplashActivity : AppCompatActivity() {

    private lateinit var mIntroGhibli : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mIntroGhibli = MediaPlayer.create(applicationContext,R.raw.intrighibli)
        mIntroGhibli.start()

        //Change to coroutines :D
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        },   SPLASH_TIME_OUT )
    }

    companion object {
        private const val SPLASH_TIME_OUT : Long = 7000;
    }
}
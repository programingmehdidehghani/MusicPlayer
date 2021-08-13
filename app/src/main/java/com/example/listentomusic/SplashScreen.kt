package com.example.listentomusic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashScreen : AppCompatActivity() {

    lateinit var image: ImageView
    lateinit var animation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image = findViewById(R.id.imageView_splashScreen)
        animation = AnimationUtils.loadAnimation(getApplicationContext(),
            R.anim.anim);

        image.startAnimation(animation)

        initListener()

    }

    private fun initListener() {
        val handler = Handler()
        handler.postDelayed({ callActivityIntent() }, 3000)
    }

    private fun callActivityIntent() {
        val intentFlag = Intent(this@SplashScreen, MainActivity::class.java)
        intentFlag.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intentFlag)
    }

    override fun onStop() {
        super.onStop()
        finish()
    }

}
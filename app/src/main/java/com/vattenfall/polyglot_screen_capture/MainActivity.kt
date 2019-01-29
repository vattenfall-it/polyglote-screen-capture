package com.vattenfall.polyglot_screen_capture

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.adamstyrc.polyglot_screen_scapture.R
import com.vattenfall.polyglot.LocaleManager

class MainActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocaleManager.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

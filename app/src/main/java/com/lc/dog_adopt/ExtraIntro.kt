package com.lc.dog_adopt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ExtraIntro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.extra)
        findViewById<TextView>(R.id.DetailName).setText("Differernt Name: Doggy" + (intent.extras?.getInt("No")).toString())
    }
}
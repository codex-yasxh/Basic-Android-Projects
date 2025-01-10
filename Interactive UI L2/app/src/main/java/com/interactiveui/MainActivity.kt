package com.interactiveui

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.LinearLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val Darkbtn = findViewById<Button>(R.id.DarkTheme)
        val Lightbtn = findViewById<Button>(R.id.LightTheme)
        val layoutChange = findViewById<LinearLayout>(R.id.LinearLayout)
        Darkbtn.setOnClickListener {
            layoutChange.setBackgroundResource(R.color.black)
        }
        Lightbtn.setOnClickListener {
            layoutChange.setBackgroundResource(R.color.white)
        }

    }
}
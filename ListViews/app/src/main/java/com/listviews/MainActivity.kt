package com.listviews

import android.os.Bundle
import android.widget.CheckBox
import android.widget.ListView
import android.widget.TextView
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var listView: ListView
    lateinit var tasklist: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Handle edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listView = findViewById(R.id.listView)
        tasklist = ArrayList()

        // Add tasks to list
        tasklist.add("Attend DBMS Exam")
        tasklist.add("Complete Android Dev Project")
        tasklist.add("Work on Resume")
        tasklist.add("Update GitHub")
        tasklist.add("Improve Online Presence")

        // Create ArrayAdapter for tasks with checkboxes
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, tasklist)
        listView.adapter = adapter

        // Set listener for checkbox click to apply strikethrough
        listView.setOnItemClickListener { _, view, position, _ ->
            val checkBox = view.findViewById<CheckBox>(android.R.id.checkbox)
            val textView = view.findViewById<TextView>(android.R.id.text1)

            if (checkBox.isChecked) {
                textView.paintFlags = textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                textView.paintFlags = textView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            }
        }
    }
}

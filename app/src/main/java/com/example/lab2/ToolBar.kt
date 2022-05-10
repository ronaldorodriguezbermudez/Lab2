package com.example.lab2

import androidx.appcompat.app.AppCompatActivity

class ToolBar {
    fun show(activities : AppCompatActivity, title:String, upButton:Boolean){
        activities.setSupportActionBar(activities.findViewById(R.id.toolbar))
        activities.supportActionBar?.title = title
        activities.supportActionBar?.setDisplayHomeAsUpEnabled(upButton)
    }
}
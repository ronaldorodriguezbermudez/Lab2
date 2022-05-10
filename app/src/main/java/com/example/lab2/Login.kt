package com.example.lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
/*
class Login : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val drawerLayout : DrawerLayout = findViewById(R.id.navDrawer)
        val navView : NavigationView = findViewById(R.id.navView)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navHome -> Toast.makeText(applicationContext, "Inicio", Toast.LENGTH_SHORT).show()
                R.id.navCatalogo -> startActivity(Intent(this, Listado::class.java))
                R.id.navPromos -> Toast.makeText(applicationContext, "Inicio", Toast.LENGTH_SHORT).show()
                R.id.navInfo -> Toast.makeText(applicationContext, "Inicio", Toast.LENGTH_SHORT).show()
                R.id.navContacto -> Toast.makeText(applicationContext, "Inicio", Toast.LENGTH_SHORT).show()
                R.id.navLogout -> Toast.makeText(applicationContext, "Inicio", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}*/
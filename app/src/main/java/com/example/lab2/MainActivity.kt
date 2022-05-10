package com.example.lab2

import LogicaNegocio.Libro
import LogicaNegocio.ListaLibros
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.lab2.adapters.LibroAdapter
import com.example.lab2.adapters.ViewPagerAdapter
import com.example.lab2.fragments.PromoFragment
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout : DrawerLayout = findViewById(R.id.navDrawer)
        val navView : NavigationView = findViewById(R.id.navView)
        val tabLayout=findViewById<TabLayout>(R.id.tab_layout)
        val viewPager2=findViewById<ViewPager2>(R.id.view_pager)

        //NavigationView
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navHome -> Toast.makeText(applicationContext, "Inicio", Toast.LENGTH_SHORT).show()
                R.id.navCatalogo -> startActivity(Intent(this, Listado::class.java))
                R.id.navBuscar -> startActivity(Intent(this, Buscar::class.java))
                R.id.navPromos -> startActivity(Intent(this, PromoFragment::class.java))


                R.id.navInfo -> Toast.makeText(applicationContext, "Inicio", Toast.LENGTH_SHORT).show()
                R.id.navContacto -> Toast.makeText(applicationContext, "Inicio", Toast.LENGTH_SHORT).show()
                R.id.navLogout -> Toast.makeText(applicationContext, "Inicio", Toast.LENGTH_SHORT).show()
            }
            true
        }

        //ViewPager y TabLayout
        val adapter= ViewPagerAdapter(supportFragmentManager,lifecycle)

        viewPager2.adapter=adapter

        TabLayoutMediator(tabLayout,viewPager2){tab,position->
            when(position){
                0->{
                    tab.text="Inicio"
                }
                1->{
                    tab.text="Promociones"
                }
            }
        }.attach()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
package com.example.acalculator.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.acalculator.ui.utils.NavigationManager
import com.example.acalculator.R
import com.example.acalculator.User
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.drawer_header.*
import java.util.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.nav_calculator -> NavigationManager.goToCalculatorFragment(
                supportFragmentManager
            )
        }
        when(item.itemId)
        {
            R.id.nav_history -> NavigationManager.goToCalculatorFragment(
                supportFragmentManager
            )
        }
        when(item.itemId)
        {
            R.id.nav_logout -> {
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
                finish()
            }
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setupDrawerMenu()
        if(!screenRotated(savedInstanceState)){
            NavigationManager.goToCalculatorFragment(
                supportFragmentManager
            )
        }
    }
    private fun screenRotated(savedInstanceState: Bundle?):Boolean{
        return savedInstanceState!=null
    }

    /*override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if(intent.getParcelableExtra<User>("user")!=null)
        {
            user = intent.getParcelableExtra<User>("user")
            txt_nome_drawer.text = user
            txt_email_drawer.text = user.email
        }
        return super.onPrepareOptionsMenu(menu)
    }*/
    private fun setupDrawerMenu()
    {

        val toggle = ActionBarDrawerToggle(this, drawer, toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        )
        nav_drawer.setNavigationItemSelectedListener(this)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

    }

    override fun onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START)
        if(supportFragmentManager.backStackEntryCount == 1) finish()
        super.onBackPressed()
    }
}




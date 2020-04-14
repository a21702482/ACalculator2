package com.example.acalculator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.drawer_header.*
import kotlinx.android.synthetic.main.item_expression.view.*
import java.util.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var user = User("","","")
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.nav_calculator -> NavigationManager.goToCalculatorFragment(supportFragmentManager)
        }
        when(item.itemId)
        {
            R.id.nav_history -> NavigationManager.goToCalculatorFragment(supportFragmentManager)
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
        NavigationManager.goToCalculatorFragment(supportFragmentManager)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if(intent.getParcelableExtra<User>("user")!=null)
        {
            user = intent.getParcelableExtra<User>("user")
            txt_nome_drawer.text = user.Username
            txt_email_drawer.text = user.email
        }
        return super.onPrepareOptionsMenu(menu)
    }
    private fun setupDrawerMenu()
    {

        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close)
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
class Operation(var expression : String,var resultado : Double) {
    val uuid: String = UUID.randomUUID().toString()
}



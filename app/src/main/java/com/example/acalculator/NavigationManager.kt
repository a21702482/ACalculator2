package com.example.acalculator

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

abstract class NavigationManager {
    companion object {
        private fun placeFragment(fm: FragmentManager, fragment: Fragment)
        {
            val transition = fm.beginTransaction()
            transition.replace(R.id.frame, fragment)
            transition.addToBackStack(null)
            transition.commit()
        }
        fun goToHistoryFragment(fm: FragmentManager)
        {
            placeFragment(fm, HistoryFragment())
        }
        fun goToCalculatorFragment(fm: FragmentManager)
        {
            placeFragment(fm, CalculatorFragment())
        }
        /*fun goToLogin()
        {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }*/
    }
}
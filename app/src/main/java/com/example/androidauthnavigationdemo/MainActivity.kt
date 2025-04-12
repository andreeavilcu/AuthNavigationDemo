package com.example.androidauthnavigationdemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


    override fun onBackPressed() {
        val currentDestination = navController.currentDestination?.id
        when (currentDestination) {
            R.id.loginFragment -> {
                finish()
            }
            R.id.registerStep1Fragment, R.id.registerStep2Fragment ->{
                navController.navigate(R.id.loginFragment)
            }
            R.id.profileFragment -> {
                finish()
            }
            else -> {
                super.onBackPressed()
            }
        }
    }
}
package com.clean.cryptoclean.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.clean.cryptoclean.R
import com.clean.cryptoclean.common.Constants


class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Constants.MAIN = this
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.place_holder) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
    }
    override fun onNavigateUp(): Boolean {
        return navController.navigateUp()|| super .onNavigateUp()
    }
}
package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.udacity.shoestore.databinding.ActivityShoesManagementBinding
import timber.log.Timber

class ShoesManagementActivity: AppCompatActivity() {

    private lateinit var binding: ActivityShoesManagementBinding

    var canBackPress = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shoes_management)
        setSupportActionBar(binding.toolbar)
        val navController = findNavController(R.id.myNavHostFragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
        Timber.plant(Timber.DebugTree())
        navController.addOnDestinationChangedListener { _, destination, _ ->
            canBackPress = destination.id != R.id.shoesListFragment
        }
    }

    override fun onBackPressed() {
        if(canBackPress){
            super.onBackPressed()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }

}
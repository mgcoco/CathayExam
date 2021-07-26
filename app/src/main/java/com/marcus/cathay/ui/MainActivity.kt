package com.marcus.cathay.ui

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.marcus.basic.ui.base.BaseActivity
import com.marcus.cathay.R
import com.marcus.cathay.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(){

    override fun initialUi() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        val navController = navHostFragment!!.navController
        val appBarConfiguration = AppBarConfiguration.Builder().build()
        setSupportActionBar(binding.toolbar)
        NavigationUI.setupWithNavController(
            binding.toolbar, navController, appBarConfiguration
        )
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id) {
                R.id.navigation_home -> {
                    binding.toolbar.setNavigationIcon(R.drawable.ic_menu)
                }
                else -> {
                    binding.toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
                }
            }
        }
    }

    override fun loadData() {
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
}
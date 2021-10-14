package com.heinhtetoo.getgo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import com.heinhtetoo.getgo.R
import com.heinhtetoo.getgo.databinding.ActivityMainBinding
import com.heinhtetoo.getgo.extensions.setupWithNavController

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var currentNavController: LiveData<NavController>? = null

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }

        init()
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavigationBar()
    }

    private fun init() {
        setupNavController()
    }

    private fun setupBottomNavigationBar() {
        val bottomNavigationView = binding.bottomNavigation

        val navGraphIds = listOf(
            R.navigation.nav_graph_rent,
            R.navigation.nav_graph_booking,
            R.navigation.nav_graph_refer,
            R.navigation.nav_graph_account
        )

        currentNavController = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_container,
            intent = intent
        )

    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }

    private fun setupNavController() {
        currentNavController?.observe(this, {
            it.addOnDestinationChangedListener(bottomNavChangeListener)
        })
    }

    private val bottomNavChangeListener: (NavController, NavDestination, Bundle?) -> Unit =
        { navController, navDestination, _ ->
            binding.bottomNavigation.isVisible =
                navDestination.id == navController.graph.startDestination
        }
}
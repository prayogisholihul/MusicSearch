package com.zogik.musicsearch

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.PopupMenu
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.zogik.core.presentation.BaseActivity
import com.zogik.musicsearch.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    private lateinit var navController: NavController
    private lateinit var menuBottom: Menu
    private lateinit var broadcastReceiver: BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
        navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                com.zogik.core.R.id.home,
                com.zogik.core.R.id.favorite,
                com.zogik.core.R.id.profile,
            ),
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navController.addOnDestinationChangedListener { _: NavController, destination: NavDestination, _: Bundle? ->
            binding.bottomBar.isVisible =
                appBarConfiguration.topLevelDestinations.contains(destination.id)
        }
        setupSmoothBottomMenu()
    }

    private fun setupSmoothBottomMenu() {
        val popupMenu = PopupMenu(this, null)
        popupMenu.inflate(com.zogik.core.R.menu.nav_menu)
        menuBottom = popupMenu.menu
        binding.bottomBar.setupWithNavController(menu = menuBottom, navController = navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onStart() {
        super.onStart()
        registerBroadCastReceiver()
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcastReceiver)
    }

    private fun registerBroadCastReceiver() {
        broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                when (intent.action) {
                    Intent.ACTION_POWER_CONNECTED -> {
                        Log.d("LeakCanary", "CONNECTED")
                    }

                    Intent.ACTION_POWER_DISCONNECTED -> {
                        Log.d("LeakCanary", "DISCONNECTED")
                    }
                }
            }
        }
        val intentFilter = IntentFilter()
        intentFilter.apply {
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
        }
        ContextCompat.registerReceiver(
            this,
            broadcastReceiver,
            intentFilter,
            ContextCompat.RECEIVER_VISIBLE_TO_INSTANT_APPS,
        )
    }
}

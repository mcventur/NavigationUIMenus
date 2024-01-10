package com.mpd.pmdm.navigationuimenus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.mpd.pmdm.navigationuimenus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.myToolbar.setupWithNavController(navController, appBarConfiguration)



        binding.myToolbar.setOnMenuItemClickListener {
            onItemClicked(it)
        }

    }

    private fun onItemClicked(item: MenuItem):Boolean {
//        when(item.itemId){
//            R.id.item_usuario -> findNavController(R.id.fragmentContainerView).navigate(R.id.userFragment)
//            R.id.item_home -> findNavController(R.id.fragmentContainerView).navigate(R.id.homeFragment)
//            else -> return false
//        }

        val navController = findNavController(R.id.fragmentContainerView)
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)

    }

}
package com.example.newfood.actvity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.newfood.R
import com.example.newfood.databinding.ActivityMainBinding
import com.example.newfood.db.MealDatabase
import com.example.newfood.viewModel.HomeViewModel
import com.example.newfood.viewModel.HomeViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val viewModel: HomeViewModel  by lazy {
      val mealDataBase = MealDatabase.getInstance(this)
      val homeViewModelProviderFactory = HomeViewModelFactory(mealDataBase)
      ViewModelProvider(this,homeViewModelProviderFactory)[HomeViewModel::class.java]
  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val bottomNavigation = findViewById<BottomNavigationView>(R.id.btn_nav)
        val navController = Navigation.findNavController(this, R.id.host_fragment)

        NavigationUI.setupWithNavController(bottomNavigation, navController)
    }
}
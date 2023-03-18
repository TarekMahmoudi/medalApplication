package com.mahmoudi.projectone.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.mahmoudi.projectone.databinding.ActivityMainBinding
import com.mahmoudi.projectone.ui.main.adapter.AchievementAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private  val viewModel: MainViewModel by viewModels()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initObserver()

    }

    private fun initObserver() {
        viewModel.achievementsSuccessLiveData.observe(this){
            response -> binding.recyclerViewAchievement.adapter = AchievementAdapter(response)
        }
        viewModel.achievementsErrorLiveData.observe(this){
            e -> Toast.makeText(this,e.localizedMessage,Toast.LENGTH_SHORT).show()
        }
        viewModel.achievementsLoadingLiveData.observe(this){
            show -> binding.progressBar.isVisible = show
        }
    }

}
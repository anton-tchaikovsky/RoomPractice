package com.example.roompractice.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.roompractice.RoomPracticeApp
import com.example.roompractice.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: FlowersViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        RoomPracticeApp.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        subscribeViewModel()
    }

    private fun initView(){
        with(binding){
            getFlowersButton.setOnClickListener {
                viewModel.getFlowers() }

            getBouquetsButton.setOnClickListener {
                viewModel.getBouquets()
            }
            getAvailableBouquetsButton.setOnClickListener {
                viewModel.getAvailableBouquets()
            }
            buyBouquetButton.setOnClickListener {
                viewModel.buyBouquets("first")
            }
        }
    }

    private fun subscribeViewModel() {
        lifecycleScope.launch {
            viewModel.flowersFlow.collect{
                binding.textView.text = it.toString()
            }
        }

        lifecycleScope.launch {
            viewModel.bouquetsFlow.collect{
                binding.textView.text = it.toString()
            }
        }

        lifecycleScope.launch {
            viewModel.availableBouquetsFlow.collect{
                binding.textView.text = it.toString()
            }
        }
    }
}
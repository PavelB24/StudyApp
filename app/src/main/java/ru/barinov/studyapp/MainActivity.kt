package ru.barinov.studyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.barinov.studyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapter by inject<RVAdapter>()

    private val vm by viewModel<ActivityViewModel>()

    private val scope = CoroutineScope(Job() + Dispatchers.IO)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setView()
        subcribeOnData()
    }

    private fun subcribeOnData() {
        lifecycleScope.launch {
            vm.devicesFlow.onEach {
                withContext(Dispatchers.Main){

                }
            }.collect()
        }
    }

    private fun setView() {
        with(binding){
            helloTextView.text = "ABV"
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}
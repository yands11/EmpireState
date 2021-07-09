package com.dot2line.empirestate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.dot2line.base.EffectObservable
import com.dot2line.base.StateObservable
import com.dot2line.empirestate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),
    StateObservable<MainState>,
    EffectObservable<MainEffect> {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.state.observe(this) { observeState(it) }
        viewModel.effect.observe(this) { observeEffect(it) }

        binding.btnFetch.setOnClickListener {
            viewModel.process(MainViewEvent.ClickButton)
        }
    }

    override fun observeState(state: MainState) {
        when (state) {
            MainState.BeforeLoad -> {
                binding.tvStatus.text = "Hello"
                binding.progress.visibility = View.GONE
            }
            MainState.Loading -> {
                binding.progress.visibility = View.VISIBLE
            }
            is MainState.AfterLoad -> {
                binding.tvStatus.text =
                    if (state.data.isNotBlank()) "DONE : ${state.data}"
                    else "empty"
                binding.progress.visibility = View.GONE
            }
        }
    }

    override fun observeEffect(effect: MainEffect) {
        when (effect) {
            MainEffect.NavigateStore -> moveToStore()
        }
    }

    private fun moveToStore() {

    }
}



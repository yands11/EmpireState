package com.dot2line.empirestate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dot2line.base.Effect
import com.dot2line.base.HasEffect
import com.dot2line.base.HasEvent
import com.dot2line.base.HasState
import com.dot2line.base.MviViewModel
import com.dot2line.base.SingleLiveEvent
import com.dot2line.base.State
import com.dot2line.base.ViewEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : MviViewModel(),
    HasState<MainState>,
    HasEvent<MainViewEvent>,
    HasEffect<MainEffect> {

    private val _state = MutableLiveData<MainState>()
    override val state: LiveData<MainState> get() = _state
    private val _effect = SingleLiveEvent<MainEffect>()
    override val effect: SingleLiveEvent<MainEffect> get() = _effect

    init {
        _state.value = MainState.BeforeLoad
    }

    override fun process(viewEvent: MainViewEvent) {
        when (viewEvent) {
            MainViewEvent.ClickButton -> onButtonClick()
        }
    }

    private fun fetchData() {
        _state.value = MainState.AfterLoad("Data")
    }

    private fun onButtonClick() {
        viewModelScope.launch {
            _state.value = MainState.Loading
            delay(1000L)
            fetchData()
        }
    }
}

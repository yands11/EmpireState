package com.dot2line.empirestate

import com.dot2line.base.Effect
import com.dot2line.base.State
import com.dot2line.base.ViewEvent

sealed class MainViewEvent : ViewEvent {
    object ClickButton : MainViewEvent()
}

data class MainState(
    val data: String
) : State

sealed class MainEffect : Effect {
    object NavigateStore : MainEffect()
}

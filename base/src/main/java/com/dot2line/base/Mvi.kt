package com.dot2line.base

import androidx.lifecycle.LiveData

// View 에 필요한 데이터 상태들
interface State

// View 에서 해야할 기대동작
interface Effect

// View 로 부터 ViewModel 로 전달되는 상황
interface ViewEvent

// 특정 State를 observe하는 경우
interface StateObservable<S : State> {
    fun observeState(state: S)
}

// 특정 Effect를 observe하는 경우
interface EffectObservable<E : Effect> {
    fun observeEffect(effect: E)
}

interface HasEvent<VS : ViewEvent> {
    fun process(viewEvent: VS)
}

interface HasState<S : State> {
    val state: LiveData<S>
}

interface HasEffect<E : Effect> {
    val effect: SingleLiveEvent<E>
}

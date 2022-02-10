package com.molol.rocketin.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(): ViewModel() {
    val instancesCount get() = counter

    init {
        counter++
    }

    companion object {
        var counter = 0
    }
}
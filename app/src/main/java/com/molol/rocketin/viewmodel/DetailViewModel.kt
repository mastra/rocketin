package com.molol.rocketin.viewmodel

import androidx.lifecycle.ViewModel

class DetailViewModel : ViewModel() {

    val instancesCount get() = counter

    init {
        counter++
    }

    companion object {
        var counter = 0
    }
}
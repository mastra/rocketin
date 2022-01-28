package com.molol.rocketin.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.molol.rocketin.model.Bar
import com.molol.rocketin.model.repository.BarRepository
import kotlinx.coroutines.launch

class ListViewModel(val repository: BarRepository) : ViewModel( ) {
      var starbacks = mutableStateOf( emptyList<Bar>())

      init {
            viewModelScope.launch {
                  starbacks.value = repository.search("starbucks") ?: emptyList()
            }

      }
}
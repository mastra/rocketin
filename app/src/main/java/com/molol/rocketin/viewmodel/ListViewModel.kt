package com.molol.rocketin.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.molol.rocketin.model.Bar
import com.molol.rocketin.model.repository.BarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(val repository: BarRepository) : ViewModel( ) {
      val starbacks = mutableStateOf( emptyList<Bar>())

      init {
            viewModelScope.launch {
                  starbacks.value = repository.search("starbucks") ?: emptyList()
            }

      }
}
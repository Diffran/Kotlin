package com.example.ciclevida.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.ciclevida.model.CicleVidaEvent

class CicleVidaViewModel: ViewModel() {
    private val _cicleVidaEvents = mutableStateOf(listOf<CicleVidaEvent>())
    val cicleVidaEvents: State<List<CicleVidaEvent>> = _cicleVidaEvents

    fun addEvent(nomEvent: String) {
        _cicleVidaEvents.value = _cicleVidaEvents.value + CicleVidaEvent(nomEvent)
    }

    fun resetEvents() {
        _cicleVidaEvents.value = emptyList()
    }
}
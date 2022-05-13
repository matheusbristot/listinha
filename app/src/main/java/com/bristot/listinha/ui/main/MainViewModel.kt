package com.bristot.listinha.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle

import androidx.lifecycle.ViewModel
import com.bristot.listinha.domain.RandomUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val handleState: SavedStateHandle,
    private val randomUseCase: RandomUseCase
) : ViewModel() {

    val data: LiveData<String> get() = dataEvent
    private val dataEvent = MutableLiveData<String>()

    fun onRandom() {
        val randomText = randomUseCase()
        dataEvent.postValue(randomText)
    }
}

package com.example.alkewalletbilleterakotlin.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.alkewalletbilleterakotlin.data.repository.TransferenciaRepository

class TransferenciaViewModelFactory (private val transferenciaRepository: TransferenciaRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TransferenciaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TransferenciaViewModel(transferenciaRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
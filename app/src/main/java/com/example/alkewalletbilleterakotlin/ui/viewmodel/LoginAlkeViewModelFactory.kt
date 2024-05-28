package com.example.alkewalletbilleterakotlin.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.alkewalletbilleterakotlin.data.repository.UsuarioRepository

class LoginAlkeViewModelFactory(private val usuarioRepository: UsuarioRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginAlkeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LoginAlkeViewModel(usuarioRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
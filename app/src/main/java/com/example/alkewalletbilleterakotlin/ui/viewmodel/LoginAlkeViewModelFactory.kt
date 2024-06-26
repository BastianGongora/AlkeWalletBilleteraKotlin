package com.example.alkewalletbilleterakotlin.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.alkewalletbilleterakotlin.data.repository.UsuarioRepository

/**
 * Clase de factory para crear instancias de [LoginAlkeViewModel] con un [UsuarioRepository].
 *
 * @property usuarioRepository El repositorio de usuarios.
 */
class LoginAlkeViewModelFactory(private val usuarioRepository: UsuarioRepository) : ViewModelProvider.Factory {

/**
 * Crea una nueva instancia de la clase [ViewModel].
 *
 * @param modelClass La clase del ViewModel a crear.
 * @return Un ViewModel recién creado.
 * @throws IllegalArgumentException si la clase dada no se puede asignar desde [LoginAlkeViewModel].*/

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginAlkeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LoginAlkeViewModel(usuarioRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
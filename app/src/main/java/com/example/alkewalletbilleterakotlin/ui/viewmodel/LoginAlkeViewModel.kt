package com.example.alkewalletbilleterakotlin.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alkewalletbilleterakotlin.data.model.Usuario
import com.example.alkewalletbilleterakotlin.data.repository.UsuarioRepository

class LoginAlkeViewModel(private val usuarioRepository: UsuarioRepository) : ViewModel() {

    private val _usuarioActual = MutableLiveData<Usuario?>()
    val usuarioActual: LiveData<Usuario?> get() = _usuarioActual

    fun login(email: String, password: String) {
        _usuarioActual.value = usuarioRepository.getUsuario(email, password)
    }

    fun setUsuarioActual(usuario: Usuario) {
        _usuarioActual.value = usuario
    }

    fun register(nombre: String, apellido: String, email: String, password: String, saldo: Double) {
        val nuevoUsuario = Usuario(nombre, apellido, email, password, saldo)
        usuarioRepository.addUsuario(nuevoUsuario)
        _usuarioActual.value = nuevoUsuario
    }

    fun logout() {
        _usuarioActual.value = null
    }
}
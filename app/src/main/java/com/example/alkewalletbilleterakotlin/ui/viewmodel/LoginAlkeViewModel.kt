package com.example.alkewalletbilleterakotlin.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alkewalletbilleterakotlin.data.model.Usuario
import com.example.alkewalletbilleterakotlin.data.repository.UsuarioRepository

/**
 * Clase ViewModel para manejar la autenticación de usuarios y la gestión de datos de usuarios.
 *
 * @property usuarioRepository El repositorio de usuarios.
 */
class LoginAlkeViewModel(private val usuarioRepository: UsuarioRepository) : ViewModel() {

    private val _usuarioActual = MutableLiveData<Usuario?>()
    val usuarioActual: LiveData<Usuario?> get() = _usuarioActual

    fun login(email: String, password: String) {
        _usuarioActual.value = usuarioRepository.getUsuario(email, password)
    }

    /**
     * Establece el usuario actual manualmente.
     *
     * @param usuario El usuario a establecer como actual.
     */
    fun setUsuarioActual(usuario: Usuario) {
        _usuarioActual.value = usuario
    }
    /**
     * Registra un nuevo usuario.
     *
     * @param nombre El nombre del usuario.
     * @param apellido El apellido del usuario.
     * @param email El correo electrónico del usuario.
     * @param contraseña La contraseña del usuario.
     * @param saldo El saldo inicial del usuario.
     */
    fun register(nombre: String, apellido: String, email: String, password: String, saldo: Double) {
        val nuevoUsuario = Usuario(nombre, apellido, email, password, saldo)
        usuarioRepository.addUsuario(nuevoUsuario)
        _usuarioActual.value = nuevoUsuario
    }
    /**
     * Cierra la sesión del usuario actual.
     */
    fun logout() {
        _usuarioActual.value = null
    }
}
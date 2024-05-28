package com.example.alkewalletbilleterakotlin.data.repository

import com.example.alkewalletbilleterakotlin.data.model.Usuario
/**
 * Repository interface para operaciones de usuario
 */
interface UsuarioRepository {
    /**
     * Gets recibe la lista de usuario
     *
     */
    fun getListaUsuarios(): List<Usuario>
    fun addUsuario(usuario: Usuario)


    fun getUsuario(email: String, password: String): Usuario?
}
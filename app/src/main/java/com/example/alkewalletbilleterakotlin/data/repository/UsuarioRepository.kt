package com.example.alkewalletbilleterakotlin.data.repository

import com.example.alkewalletbilleterakotlin.data.model.Usuario

interface UsuarioRepository {
    fun getListaUsuarios(): List<Usuario>
    fun addUsuario(usuario: Usuario)
    fun getUsuario(email: String, password: String): Usuario?
}
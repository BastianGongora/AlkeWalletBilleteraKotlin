package com.example.alkewalletbilleterakotlin.data.repository

import com.example.alkewalletbilleterakotlin.data.model.Usuario

/**
 *  Clase Dataset
 *  @author Bastián Góngora
 *  @since v0.1 26/05/2024
 *
 * Clase Dataset que contiene una lista de datos de usuario
 *  nombre el nombre del usuario
 *  apellido el apellido del usuario
 *  email la correo electrónico del usuario
 *  password la contraseña del usuario
 *  saldo el saldo de la cuenta del usuario
 */
class UsuarioDataSet : UsuarioRepository {

    private val usuarios = mutableListOf(
        Usuario("Yara", "Khalil", "Y.K@gmail.com", "123", 35000.0),
        Usuario("Sara", "Ibrahim", "S.Ibra@gmail.com", "123", 35000.0)
    )

    override fun getListaUsuarios(): List<Usuario> = usuarios

    override fun getUsuario(email: String, password: String): Usuario? {
        return usuarios.find { it.email == email && it.password == password }
    }

    override fun addUsuario(usuario: Usuario) {
        usuarios.add(usuario)
    }
}
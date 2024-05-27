package com.example.alkewalletbilleterakotlin.data.model
/**
 *  Clase Usuario
 *  @author Bastián Góngora
 *  @since v0.1 26/05/2024
 *
 * Clase Usuario
 *
 * @property nombre el nombre del usuario
 * @property apellido el apellido del usuario
 * @property email la correo electrónico del usuario
 * @property password la contraseña del usuario
 * @property saldo el saldo de la cuenta del usuario
 */
data class Usuario(
    val nombre: String,
    val apellido: String,
    val email: String,
    val password: String,
    val saldo: Double

)


package com.example.alkewalletbilleterakotlin.data.repository

import com.example.alkewalletbilleterakotlin.data.model.Transferencia

interface TransferenciaRepository {

    fun getListaTransferencias(): List<Transferencia>
}
package com.example.alkewalletbilleterakotlin.data.repository

import com.example.alkewalletbilleterakotlin.R
import com.example.alkewalletbilleterakotlin.data.model.Transferencia

class TransferenciaDataSet : TransferenciaRepository {

    private val transferencias = mutableListOf(
        Transferencia(R.drawable.person1, "Yara Khalil", "2024-05-01", 1150.0),
        Transferencia(R.drawable.person2, "Sara Ibrahim", "2024-05-02", 2150.0)
        // Add more dummy data as needed
    )


    override fun getListaTransferencias(): List<Transferencia> = transferencias
}
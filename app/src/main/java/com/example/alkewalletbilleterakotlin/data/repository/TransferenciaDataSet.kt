package com.example.alkewalletbilleterakotlin.data.repository

import com.example.alkewalletbilleterakotlin.R
import com.example.alkewalletbilleterakotlin.data.model.Transferencia

class TransferenciaDataSet : TransferenciaRepository {

    private val transferencias = mutableListOf(
        Transferencia(R.drawable.person1, "Yara Khalil", "2024-05-01", 15.00),
        Transferencia(R.drawable.person2, "Sara Ibrahim", "2024-05-02", 20.50),
        Transferencia(R.drawable.person3, "Ahmad Ibrahim", "2024-05-02", 12.40),
        Transferencia(R.drawable.person4, "Reem Khaled", "2024-05-02", 21.30),
        Transferencia(R.drawable.person5, "Hiba Saleh", "2024-05-02", 09.00)

    )


    override fun getListaTransferencias(): List<Transferencia> = transferencias
}
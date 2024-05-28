package com.example.alkewalletbilleterakotlin.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alkewalletbilleterakotlin.data.model.Transferencia
import com.example.alkewalletbilleterakotlin.data.repository.TransferenciaRepository

class TransferenciaViewModel (private val transferenciaRepository: TransferenciaRepository) : ViewModel() {

    private val _transferencias = MutableLiveData<List<Transferencia>>()
    val transferencias: LiveData<List<Transferencia>> get() = _transferencias

    init {
        loadTransferencias()
    }
    private fun loadTransferencias() {
        _transferencias.value = transferenciaRepository.getListaTransferencias()
    }
}
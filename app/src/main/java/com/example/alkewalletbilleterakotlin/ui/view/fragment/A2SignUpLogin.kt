package com.example.alkewalletbilleterakotlin.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.alkewalletbilleterakotlin.R
import com.example.alkewalletbilleterakotlin.databinding.FragmentA2SignUpLoginBinding

/**
 *  Fragmento-Sing up Login
 *  Autor: Bastián Góngora
 *  Desde: v0.1 26/05/2024
 *
 * Fragmento de la pantalla para iniciar sesión o crear una nueva cuenta
 */
class A2SignUpLogin : Fragment() {

    private var _binding: FragmentA2SignUpLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentA2SignUpLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCrearCuenta.setOnClickListener {
            findNavController().navigate(R.id.action_a2SignUpLogin_to_a4SignUp)
        }

        binding.txtYaCuenta.setOnClickListener {
            findNavController().navigate(R.id.action_a2SignUpLogin_to_a3Login)
        }
    }

    /**
     * Método llamado cuando la vista asociada con el fragmento está siendo destruida.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Evita fugas de memoria
    }
}
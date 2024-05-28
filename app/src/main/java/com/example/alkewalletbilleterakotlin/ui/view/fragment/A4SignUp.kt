package com.example.alkewalletbilleterakotlin.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.alkewalletbilleterakotlin.R
import com.example.alkewalletbilleterakotlin.databinding.FragmentA4SignUpBinding


/**
 *  Fragmento- Sign Up
 *  Autor: Bastián Góngora
 *  Desde: v0.1 27/05/2024
 *
 * Fragmento de la pantalla para crear cuenta
 */
class A4SignUp : Fragment() {

    private var _binding: FragmentA4SignUpBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?  {
        _binding = FragmentA4SignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCrearSignup.setOnClickListener {
            findNavController().navigate(R.id.action_a4SignUp_to_a5Home)
        }

        binding.txtYaCuentaSignup.setOnClickListener {
            findNavController().navigate(R.id.action_a4SignUp_to_a3Login)
        }
    }
}
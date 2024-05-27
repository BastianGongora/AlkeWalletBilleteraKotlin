package com.example.alkewalletbilleterakotlin.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.alkewalletbilleterakotlin.R
import com.example.alkewalletbilleterakotlin.databinding.FragmentA3LoginBinding
import com.example.alkewalletbilleterakotlin.ui.viewmodel.LoginAlkeViewModel

/**
 *  Fragmento- Login
 *  Autor: Bastián Góngora
 *  Desde: v0.1 26/05/2024
 *
 * Fragmento de la pantalla para iniciar sesion
 */
class A3Login : Fragment() {

    private var _binding: FragmentA3LoginBinding? = null
    private val binding get() = _binding!!

    private val loginAlkeViewModel: LoginAlkeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentA3LoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtCrearCuenta.setOnClickListener {
            findNavController().navigate(R.id.action_a3Login_to_a4SignUp)
        }

        binding.btnLogeo.setOnClickListener {LoginUserAlkewallet()}
    }
    fun LoginUserAlkewallet(){

        val email = binding.txtEmailLogin.text.toString()
        val password = binding.txtPassLogin.text.toString()

        val usuario = loginAlkeViewModel.login(email, password)

        if (usuario != null) {
            loginAlkeViewModel.login(email, password)
            findNavController().navigate(R.id.action_a3Login_to_a5Home)
        } else {
            Toast.makeText(requireContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

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
import com.example.alkewalletbilleterakotlin.data.repository.UsuarioDataSet
import com.example.alkewalletbilleterakotlin.databinding.FragmentA3LoginBinding
import com.example.alkewalletbilleterakotlin.ui.viewmodel.LoginAlkeViewModel
import com.example.alkewalletbilleterakotlin.ui.viewmodel.LoginAlkeViewModelFactory
/**
 *  Fragmento-Login
 *  Autor: Bastián Góngora
 *  Desde: v0.1 27/05/2024
 *
 * Fragmento de la pantalla para iniciar sesión
 */
class A3Login : Fragment() {

    private var _binding: FragmentA3LoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var loginAlkeViewModel: LoginAlkeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentA3LoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val usuarioRepository = UsuarioDataSet()
        val factory = LoginAlkeViewModelFactory(usuarioRepository)
        loginAlkeViewModel = ViewModelProvider(requireActivity(), factory).get(LoginAlkeViewModel::class.java)

        // Observa los cambios en usuarioActual una vez
        loginAlkeViewModel.usuarioActual.observe(viewLifecycleOwner) { usuario ->
            if (usuario != null) {
                findNavController().navigate(R.id.action_a3Login_to_a5Home)
            } else {
                Toast.makeText(context, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }
        }

        binding.txtCrearCuenta.setOnClickListener {
            findNavController().navigate(R.id.action_a3Login_to_a4SignUp)
        }

        binding.btnLogeo.setOnClickListener {
            val email = binding.txtEmailLogin.text.toString()
            val password = binding.txtPassLogin.text.toString()
            loginAlkeViewModel.login(email, password)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
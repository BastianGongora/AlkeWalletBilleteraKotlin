package com.example.alkewalletbilleterakotlin.ui.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.alkewalletbilleterakotlin.R
import com.example.alkewalletbilleterakotlin.data.repository.UsuarioDataSet
import com.example.alkewalletbilleterakotlin.databinding.FragmentA5HomeBinding
import com.example.alkewalletbilleterakotlin.ui.viewmodel.LoginAlkeViewModel
import com.example.alkewalletbilleterakotlin.ui.viewmodel.LoginAlkeViewModelFactory


/**
 *  Fragmento- Home
 *  Autor: Bastián Góngora
 *  Desde: v0.1 27/05/2024
 *
 * Fragmento de la pantalla para ver los datos del usuario y poder ingresar y enviar dinero
 */

class A5Home : Fragment() {

    private var _binding: FragmentA5HomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var loginAlkeViewModel: LoginAlkeViewModel
    /**
     * Infla el diseño de este fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentA5HomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    /**
     * Se llama cuando se crea la vista. Configura observadores e inicializa ViewModel.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val usuarioRepository = UsuarioDataSet()
        val factory = LoginAlkeViewModelFactory(usuarioRepository)
        loginAlkeViewModel = ViewModelProvider(requireActivity(), factory).get(LoginAlkeViewModel::class.java)

        // Observa los cambios en usuarioActual
        loginAlkeViewModel.usuarioActual.observe(viewLifecycleOwner) { usuario ->
            if (usuario != null) {
                binding.txtSaludo.text = "Hola ${usuario.nombre}!"
                binding.txtbalance.text = "$${usuario.saldo}"
            }
        }
    }
    /**
     * Se llama cuando se destruye la vista. Limpia la referencia vinculante.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
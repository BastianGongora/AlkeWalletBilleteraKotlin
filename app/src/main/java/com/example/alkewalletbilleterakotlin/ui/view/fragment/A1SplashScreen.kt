package com.example.alkewalletbilleterakotlin.ui.view.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.alkewalletbilleterakotlin.R

/**
 *  Fragmento-Splash Screen
 *  @author Bastián Góngora
 *  @since v0.1 26/05/2024
 *
 * Fragmento que representa la pantalla de carga inicial de la aplicación.
 */


class A1SplashScreen : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a1_splash_screen, container, false)
    }
    /**
     * Método para redirijir framento con tiempo de retraso
     *
     * @param duracionPantalla contiene el tiempo que tardara antes de redirijer al siguiente fragmento
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         val duracionPantalla = 2000L

        Handler(Looper.getMainLooper()).postDelayed({
            // Redirije una vez el tiempo transcurrido
            findNavController().navigate(R.id.a2SignUpLogin)
        }, duracionPantalla)
    }
}
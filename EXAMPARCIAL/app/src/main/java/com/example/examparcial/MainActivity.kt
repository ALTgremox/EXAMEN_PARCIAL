package com.example.examparcial

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.examparcial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mostrar el AlertDialog con las reglas del juego al iniciar
        mostrarReglas()

        // Botón "Iniciar juego"
        binding.btnIniciarJuego.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragmentContainer, GameFragment())
                addToBackStack(null)
            }
        }
    }

    private fun mostrarReglas() {
        val mensaje = """
            🟩 Bienvenido al Juego de Colores 🟥
            
            REGLAS:
            1️⃣ Aparecerá un color en pantalla.
            2️⃣ Presiona el botón del color que coincida.
            3️⃣ Cada acierto suma un punto.
            4️⃣ Tienes 30 segundos para lograr el mayor puntaje posible.
            
            ¡Demuestra tus reflejos y tu rapidez!
        """.trimIndent()

        AlertDialog.Builder(this)
            .setTitle("Reglas del Juego")
            .setMessage(mensaje)
            .setPositiveButton("Aceptar", DialogInterface.OnClickListener { dialog, _ ->
                dialog.dismiss()
            })
            .show()
    }
}

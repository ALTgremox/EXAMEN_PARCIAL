package com.example.examparcial

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.examparcial.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!

    private var score = 0
    private var timeLeft = 30
    private var currentColor = Color.RED
    private var timer: CountDownTimer? = null

    private val colorMap = mapOf(
        "Rojo" to Color.RED,
        "Verde" to Color.GREEN,
        "Azul" to Color.BLUE,
        "Amarillo" to Color.YELLOW
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniciarJuego()
        configurarBotones()
    }

    private fun iniciarJuego() {
        score = 0
        timeLeft = 30
        binding.tvScore.text = "Puntaje: $score"
        binding.tvTimer.text = "Tiempo: ${timeLeft}s"

        mostrarColorAleatorio()
        iniciarTemporizador()
    }

    private fun configurarBotones() {
        binding.btnRojo.setOnClickListener { verificarRespuesta(Color.RED) }
        binding.btnVerde.setOnClickListener { verificarRespuesta(Color.GREEN) }
        binding.btnAzul.setOnClickListener { verificarRespuesta(Color.BLUE) }
        binding.btnAmarillo.setOnClickListener { verificarRespuesta(Color.YELLOW) }
    }

    private fun verificarRespuesta(colorSeleccionado: Int) {
        if (colorSeleccionado == currentColor) {
            score++
            binding.tvScore.text = "Puntaje: $score"
        }
        mostrarColorAleatorio()
    }

    private fun mostrarColorAleatorio() {
        val colores = colorMap.values.toList()
        currentColor = colores.random()
        binding.vistaColor.setBackgroundColor(currentColor)
    }

    private fun iniciarTemporizador() {
        timer?.cancel()
        timer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = (millisUntilFinished / 1000).toInt()
                binding.tvTimer.text = "Tiempo: ${timeLeft}s"
            }

            override fun onFinish() {
                binding.tvTimer.text = "¡Tiempo terminado!"
                irAResultados()
            }
        }.start()
    }

    private fun irAResultados() {
        val resultFragment = ResultFragment.newInstance(score)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, resultFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        timer?.cancel()
        _binding = null
    }
}
package com.example.examparcial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examparcial.data.AppDatabase
import com.example.examparcial.data.ScoreEntity
import com.example.examparcial.databinding.FragmentResultBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    private var finalScore: Int = 0

    companion object {
        private const val ARG_SCORE = "score"

        fun newInstance(score: Int): ResultFragment {
            val fragment = ResultFragment()
            val args = Bundle()
            args.putInt(ARG_SCORE, score)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        finalScore = arguments?.getInt(ARG_SCORE) ?: 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        guardarYMostrarResultados()
        binding.btnReiniciar.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, GameFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun guardarYMostrarResultados() {
        val db = AppDatabase.getDatabase(requireContext())
        val dao = db.scoreDao()

        lifecycleScope.launch(Dispatchers.IO) {
            // Guardar puntaje actual
            dao.insertScore(ScoreEntity(puntos = finalScore))

            // Recuperar puntajes y récord
            val scores = dao.getAllScores()
            val maxScore = dao.getMaxScore() ?: 0

            withContext(Dispatchers.Main) {
                binding.tvFinalScore.text = "Puntaje final: $finalScore"
                binding.tvHighScore.text = "Puntaje más alto: $maxScore"

                // Mostrar historial en RecyclerView
                binding.recyclerHistorial.layoutManager = LinearLayoutManager(requireContext())
                binding.recyclerHistorial.adapter = PuntajeAdapter(scores.map { it.puntos })
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

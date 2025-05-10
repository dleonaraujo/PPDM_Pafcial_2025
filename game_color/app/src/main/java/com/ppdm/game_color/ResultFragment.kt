package com.ppdm.game_color

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ResultFragment : Fragment() {

    private lateinit var TextoPuntaje: TextView
    private lateinit var TextoMensaje: TextView
    private lateinit var TextoPuntajeAlto: TextView
    private lateinit var BotonJugarDeNuevo: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        TextoPuntaje = view.findViewById(R.id.TextoPuntaje)
        TextoMensaje = view.findViewById(R.id.TextoMensaje)
        TextoPuntajeAlto = view.findViewById(R.id.TextoPuntajeAlto)
        BotonJugarDeNuevo = view.findViewById(R.id.BotonJugarDeNuevo)

        val args = ResultFragmentArgs.fromBundle(requireArguments())
        val finalScore = args.score

        TextoPuntaje.text = "Puntaje: $finalScore"
        TextoMensaje.text = getMessageForScore(finalScore)

        val prefs = requireContext().getSharedPreferences("color_game", Context.MODE_PRIVATE)
        val highScore = prefs.getInt("high_score", 0)

        if (finalScore > highScore) {
            prefs.edit().putInt("high_score", finalScore).apply()
            TextoPuntajeAlto.text = "🥇 ¡Nuevo récord!: $finalScore"
        } else {
            TextoPuntajeAlto.text = "Puntaje más alto: $highScore"
        }

        BotonJugarDeNuevo.setOnClickListener {
            findNavController().navigate(R.id.action_result_to_welcome)
        }
    }

    private fun getMessageForScore(score: Int): String {
        return when {
            score >= 20 -> "¡Impresionante!"
            score >= 10 -> "¡Buen trabajo!"
            else -> "¡Sigue practicando!"
        }
    }
}

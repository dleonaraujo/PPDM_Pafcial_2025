package com.ppdm.game_color

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.tool.Context
import androidx.fragment.app.Fragment

class ResultFragment : Fragment() {

    private lateinit var scoreText: TextView
    private lateinit var messageText: TextView
    private lateinit var highScoreText: TextView
    private lateinit var playAgainButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        scoreText = view.findViewById(R.id.scoreText)
        messageText = view.findViewById(R.id.messageText)
        highScoreText = view.findViewById(R.id.highScoreText)
        playAgainButton = view.findViewById(R.id.playAgainButton)

        val args = ResultFragmentArgs.fromBundle(requireArguments())
        val finalScore = args.score

        scoreText.text = "Puntaje: $finalScore"
        messageText.text = getMessageForScore(finalScore)

        val prefs = requireContext().getSharedPreferences("color_game", Context.MODE_PRIVATE)
        val highScore = prefs.getInt("high_score", 0)

        if (finalScore > highScore) {
            prefs.edit().putInt("high_score", finalScore).apply()
            highScoreText.text = "🥇 ¡Nuevo récord!: $finalScore"
        } else {
            highScoreText.text = "Puntaje más alto: $highScore"
        }

        playAgainButton.setOnClickListener {
            findNavController().navigate(R.id.action_result_to_welcome)
        }
    }

    private fun getMessageForScore(score: Int): String {
        return when {
            score >= 20 -> "¡Impresionante! 🧠"
            score >= 10 -> "¡Buen trabajo! 💪"
            else -> "¡Sigue practicando! 😅"
        }
    }
}

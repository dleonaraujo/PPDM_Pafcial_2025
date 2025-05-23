package com.ppdm.game_color

import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class GameFragment : Fragment() {

    private lateinit var colorView: View
    private lateinit var scoreText: TextView
    private lateinit var timerText: TextView
    private lateinit var countDownTimer: CountDownTimer
    private var score = 0
    private var currentColor = 0

    private lateinit var sonidoGanar: MediaPlayer
    private lateinit var sonidoPerder: MediaPlayer

    private val colors = listOf(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW)
    private val colorNames = listOf("Rojo", "Verde", "Azul", "Amarillo")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        colorView = view.findViewById(R.id.colorView)
        scoreText = view.findViewById(R.id.scoreText)
        timerText = view.findViewById(R.id.timerText)

        sonidoGanar = MediaPlayer.create(requireContext(), R.raw.ganar)
        sonidoPerder = MediaPlayer.create(requireContext(), R.raw.perder)

        view.findViewById<Button>(R.id.botonRojo).setOnClickListener { checkAnswer(Color.RED) }
        view.findViewById<Button>(R.id.botonVerde).setOnClickListener { checkAnswer(Color.GREEN) }
        view.findViewById<Button>(R.id.botonAzul).setOnClickListener { checkAnswer(Color.BLUE) }
        view.findViewById<Button>(R.id.botonAmarillo).setOnClickListener { checkAnswer(Color.YELLOW) }

        startGame()
    }

    private fun startGame() {
        score = 0
        updateScore()

        showRandomColor()

        countDownTimer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timerText.text = "Tiempo: ${millisUntilFinished / 1000}s"
            }

            override fun onFinish() {
                val action = GameFragmentDirections.actionGameToResult(score)
                findNavController().navigate(action)
            }
        }
        countDownTimer.start()
    }

    private fun showRandomColor() {
        currentColor = colors.random()
        colorView.setBackgroundColor(currentColor)
    }

    private fun checkAnswer(colorPressed: Int) {
        if (colorPressed == currentColor) {
            score++
            sonidoGanar.start()
        } else {
            sonidoPerder.start()
        }
        updateScore()
        showRandomColor()
    }

    private fun updateScore() {
        scoreText.text = "Puntos: $score"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        countDownTimer.cancel()
        sonidoGanar.release()
        sonidoPerder.release()
    }
}

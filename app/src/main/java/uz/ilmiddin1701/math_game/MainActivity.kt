package uz.ilmiddin1701.math_game

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import uz.ilmiddin1701.math_game.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var number1 = 0
    private var number2 = 0
    private var answer = 0
    private var amal = 0
    private var userInputAnswer = 0
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        random()
        binding.apply {
            btn0.setOnClickListener {
                if (tvAnswer.text.length < 13) {
                    tvAnswer.append("0")
                    tvAnswer.setBackgroundResource(R.drawable.tv_style)
                    tvAnswer.setTextColor(Color.parseColor("#2C2C2C"))
                    tvAnswer.setHintTextColor(Color.parseColor("#8BC38D"))
                }
                vibrate(this@MainActivity)
            }
            btn1.setOnClickListener {
                if (tvAnswer.text.length < 13) {
                    tvAnswer.append("1")
                    tvAnswer.setBackgroundResource(R.drawable.tv_style)
                    tvAnswer.setTextColor(Color.parseColor("#2C2C2C"))
                    tvAnswer.setHintTextColor(Color.parseColor("#8BC38D"))
                }
                vibrate(this@MainActivity)
            }
            btn2.setOnClickListener {
                if (tvAnswer.text.length < 13) {
                    tvAnswer.append("2")
                    tvAnswer.setBackgroundResource(R.drawable.tv_style)
                    tvAnswer.setTextColor(Color.parseColor("#2C2C2C"))
                    tvAnswer.setHintTextColor(Color.parseColor("#8BC38D"))
                }
                vibrate(this@MainActivity)
            }
            btn3.setOnClickListener {
                if (tvAnswer.text.length < 13) {
                    tvAnswer.append("3")
                    tvAnswer.setBackgroundResource(R.drawable.tv_style)
                    tvAnswer.setTextColor(Color.parseColor("#2C2C2C"))
                    tvAnswer.setHintTextColor(Color.parseColor("#8BC38D"))
                }
                vibrate(this@MainActivity)
            }
            btn4.setOnClickListener {
                if (tvAnswer.text.length < 13) {
                    tvAnswer.append("4")
                    tvAnswer.setBackgroundResource(R.drawable.tv_style)
                    tvAnswer.setTextColor(Color.parseColor("#2C2C2C"))
                    tvAnswer.setHintTextColor(Color.parseColor("#8BC38D"))
                }
                vibrate(this@MainActivity)
            }
            btn5.setOnClickListener {
                if (tvAnswer.text.length < 13) {
                    tvAnswer.append("5")
                    tvAnswer.setBackgroundResource(R.drawable.tv_style)
                    tvAnswer.setTextColor(Color.parseColor("#2C2C2C"))
                    tvAnswer.setHintTextColor(Color.parseColor("#8BC38D"))
                }
                vibrate(this@MainActivity)
            }
            btn6.setOnClickListener {
                if (tvAnswer.text.length < 13) {
                    tvAnswer.append("6")
                    tvAnswer.setBackgroundResource(R.drawable.tv_style)
                    tvAnswer.setTextColor(Color.parseColor("#2C2C2C"))
                    tvAnswer.setHintTextColor(Color.parseColor("#8BC38D"))
                }
                vibrate(this@MainActivity)
            }
            btn7.setOnClickListener {
                if (tvAnswer.text.length < 12) {
                    tvAnswer.append("7")
                    tvAnswer.setBackgroundResource(R.drawable.tv_style)
                    tvAnswer.setTextColor(Color.parseColor("#2C2C2C"))
                    tvAnswer.setHintTextColor(Color.parseColor("#8BC38D"))
                }
                vibrate(this@MainActivity)
            }
            btn8.setOnClickListener {
                if (tvAnswer.text.length < 13) {
                    tvAnswer.append("8")
                    tvAnswer.setBackgroundResource(R.drawable.tv_style)
                    tvAnswer.setTextColor(Color.parseColor("#2C2C2C"))
                    tvAnswer.setHintTextColor(Color.parseColor("#8BC38D"))
                }
                vibrate(this@MainActivity)
            }
            btn9.setOnClickListener {
                if (tvAnswer.text.length < 13) {
                    tvAnswer.append("9")
                    tvAnswer.setBackgroundResource(R.drawable.tv_style)
                    tvAnswer.setTextColor(Color.parseColor("#2C2C2C"))
                    tvAnswer.setHintTextColor(Color.parseColor("#8BC38D"))
                }
                vibrate(this@MainActivity)
            }
            btnBackspace.setOnClickListener {
                val currentText = tvAnswer.text.toString()
                tvAnswer.setBackgroundResource(R.drawable.tv_style)
                tvAnswer.setTextColor(Color.parseColor("#2C2C2C"))
                tvAnswer.setHintTextColor(Color.parseColor("#8BC38D"))
                if (currentText.isNotEmpty()) {
                    tvAnswer.text = currentText.substring(0, currentText.length - 1)
                    vibrate(this@MainActivity)
                } else {
                    tvAnswer.text = ""
                    vibrate(this@MainActivity)
                }
            }
            btnBackspace.setOnLongClickListener {
                tvAnswer.text = ""
                tvAnswer.setTextColor(Color.parseColor("#2C2C2C"))
                tvAnswer.setHintTextColor(Color.parseColor("#8BC38D"))
                tvAnswer.setBackgroundResource(R.drawable.tv_style)
                vibrate(this@MainActivity)
                true
            }
            btnNext.setOnClickListener {
                vibrate(this@MainActivity)
                if (binding.tvAnswer.text.isNotEmpty()) {
                    userInputAnswer = binding.tvAnswer.text.toString().toInt()
                    if (userInputAnswer == answer) {
                        val mediaPlayer = MediaPlayer.create(this@MainActivity, R.raw.true_music)
                        mediaPlayer.start()
                        random()
                        binding.tvAnswer.text = ""
                    } else {
                        val mediaPlayer = MediaPlayer.create(this@MainActivity, R.raw.error_music)
                        mediaPlayer.start()
                        tvAnswer.setTextColor(Color.WHITE)
                        tvAnswer.setBackgroundResource(R.drawable.error_tv_style)
                    }
                } else {
                    tvAnswer.setHintTextColor(Color.WHITE)
                    tvAnswer.setBackgroundResource(R.drawable.error_tv_style)
                }
            }
        }
    }

    private fun random() {
        number1 = Random().nextInt(30)
        number2 = Random().nextInt(30)
        amal = Random().nextInt(4)
        showDisplay()
    }

    @SuppressLint("SetTextI18n")
    fun showDisplay() {
        when (amal) {
            0 -> {
                answer = number1 + number2
                binding.tvQuestion.text = "$number1 + $number2 = ?"
            }
            1 -> {
                if (number1 - number2 > 0) {
                    answer = number1 - number2
                    binding.tvQuestion.text = "$number1 - $number2 = ?"
                } else {
                    random()
                }
            }
            2 -> {
                answer = number1 * number2
                binding.tvQuestion.text = "$number1 * $number2 = ?"
            }
            3 -> {
                if (number1 % number2 == 0) {
                    answer = number1 / number2
                    binding.tvQuestion.text = "$number1 / $number2 = ?"
                } else {
                    random()
                }
            }
        }
    }

    private fun vibrate(context: Context) {
        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE))
        } else {
            vibrator.vibrate(50) // Old versions
        }
    }
}
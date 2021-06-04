package com.example.luckygames

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.luckygames.databinding.ActivityRollADiceBinding

class RollADice : AppCompatActivity() {
    lateinit var binding:ActivityRollADiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRollADiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        back to all games
        binding.backArrow.setOnClickListener{
            val intent= Intent(this@RollADice,AllGames::class.java)
            startActivity(intent)
        }
//        user rolls a dice
        binding.rollButton.setOnClickListener{ rollDice() }

    }
    private fun rollDice(){
        val diceImage:ImageView=binding.diceImage
        val diceNum:TextView=binding.rolledNumber
        when(Dice(6).roll()){
            1->{
                diceImage.setImageResource(R.drawable.dice_1)
                diceNum.text="One"
            }
            2->{
                diceImage.setImageResource(R.drawable.dice_2)
                diceNum.text="Two"
            }
            3-> {
                diceImage.setImageResource(R.drawable.dice_3)
                diceNum.text="Three"
            }
            4-> {
                diceImage.setImageResource(R.drawable.dice_4)
                diceNum.text="Four"
            }
            5-> {
                diceImage.setImageResource(R.drawable.dice_5)
                diceNum.text="Five"
            }
            else-> {
                diceImage.setImageResource(R.drawable.dice_6)
                diceNum.text="Six"
            }
        }

    }

}
class Dice(private val sides:Int) {

    fun roll(): Int {
        return (1..sides).random()
    }

}

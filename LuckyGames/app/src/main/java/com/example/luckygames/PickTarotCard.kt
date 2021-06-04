package com.example.luckygames

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.luckygames.databinding.ActivityPickTarotCardBinding

class PickTarotCard : AppCompatActivity() {

    lateinit var binding:ActivityPickTarotCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityPickTarotCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

//      back to all games
        binding.backArrow.setOnClickListener{
            val intent= Intent(this@PickTarotCard,AllGames::class.java)
            startActivity(intent)
        }
//        draw a card
        binding.drawCardButton.setOnClickListener { drawCard() }
    }
    private fun drawCard(){
        val cardImage:ImageView=binding.card
        val cardName:TextView=binding.cardName
        val card=Tarot(22)
        val cardResult=card.draw()
        when(cardResult){
            0-> {
                cardImage.setImageResource(R.drawable.tarot_00_fool)
                cardName.text=getString(R.string.the_fool)
            }
            1-> {
                cardImage.setImageResource(R.drawable.tarot_01_magician)
                cardName.text=getString(R.string.the_magician)
            }
            2-> {
                cardImage.setImageResource(R.drawable.tarot_02_high_priestess)
                cardName.text=getString(R.string.the_high_priestess)
            }
            3-> {
                cardImage.setImageResource(R.drawable.tarot_03_empress)
                cardName.text=getString(R.string.the_empress)
            }
            4-> {
                cardImage.setImageResource(R.drawable.tarot_04_emperor)
                cardName.text=getString(R.string.the_emperor)
            }
            5-> {
                cardImage.setImageResource(R.drawable.tarot_05_hierophant)
                cardName.text=getString(R.string.the_hierophant)
            }
            6-> {
                cardImage.setImageResource(R.drawable.tarot_06_lovers)
                cardName.text=getString(R.string.the_lovers)
            }
            7-> {
                cardImage.setImageResource(R.drawable.tarot_07_chariot)
                cardName.text=getString(R.string.the_chariot)
            }
            8-> {
                cardImage.setImageResource(R.drawable.tarot_08_strength)
                cardName.text=getString(R.string.strength)
            }
            9-> {
                cardImage.setImageResource(R.drawable.tarot_09_hermit)
                cardName.text=getString(R.string.the_hermit)
            }
            10-> {
                cardImage.setImageResource(R.drawable.tarot_10_wheel_of_fortune)
                cardName.text=getString(R.string.wheel_of_fortune)
            }
            11-> {
                cardImage.setImageResource(R.drawable.tarot_11_justice)
                cardName.text=getString(R.string.justice)
            }
            12-> {
                cardImage.setImageResource(R.drawable.tarot_12_hanged_man)
                cardName.text=getString(R.string.the_hanged_man)
            }
            13-> {
                cardImage.setImageResource(R.drawable.tarot_13_death)
                cardName.text=getString(R.string.death)
            }
            14-> {
                cardImage.setImageResource(R.drawable.tarot_14_temperance)
                cardName.text=getString(R.string.temperance)
            }
            15-> {
                cardImage.setImageResource(R.drawable.tarot_15_devil)
                cardName.text=getString(R.string.the_devil)
            }
            16-> {
                cardImage.setImageResource(R.drawable.tarot_16_tower)
                cardName.text=getString(R.string.the_tower)
            }
            17-> {
                cardImage.setImageResource(R.drawable.tarot_17_star)
                cardName.text=getString(R.string.the_star)
            }
            18-> {
                cardImage.setImageResource(R.drawable.tarot_18_moon)
                cardName.text=getString(R.string.the_moon)
            }
            19-> {
                cardImage.setImageResource(R.drawable.tarot_19_sun_)
                cardName.text=getString(R.string.the_sun)
            }
            20-> {
                cardImage.setImageResource(R.drawable.tarot_20_judgement)
                cardName.text=getString(R.string.judgement)
            }
            21-> {
                cardImage.setImageResource(R.drawable.tarot_21_world)
                cardName.text=getString(R.string.the_world)
            }
            else->{
                cardImage.setImageResource(R.drawable.tarot_back_1)
                cardName.text=getString(R.string.draw_again)
            }

        }
    }
}
class Tarot(private val numberOfCards:Int){
    fun draw(): Int {
        return (0 until numberOfCards).random()
    }
}
package com.example.luckygames

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.luckygames.databinding.ActivityFlipACoinBinding

class FlipACoin : AppCompatActivity() {
    lateinit var binding:ActivityFlipACoinBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFlipACoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        back button
        binding.backArrow.setOnClickListener{
            val intent= Intent(this@FlipACoin,AllGames::class.java)
            startActivity(intent)
        }
//        flip a coin
        binding.flipButton.setOnClickListener { flipCoin() }


    }
    private fun flipCoin(){
        val coinImage:ImageView=binding.coinImage
        val coinNum=binding.headsOrTails
        when(Coin().flip()){
            0->{
                coinImage.setImageResource(R.drawable.coin_2_leva_face)
                coinNum.text=getString(R.string.heads_coin)
            }
            else->{
                coinImage.setImageResource(R.drawable.coin_2_leva_back)
                coinNum.text=getString(R.string.tails_coin)
            }
        }
    }
}
class Coin(){
    fun flip():Int{
        return (0..1).random()
    }
}
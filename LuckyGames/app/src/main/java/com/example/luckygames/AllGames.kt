package com.example.luckygames

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.luckygames.databinding.ActivityAllGamesBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class AllGames : AppCompatActivity() {
    lateinit var binding:ActivityAllGamesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityAllGamesBinding.inflate(layoutInflater)
        setContentView(binding.root)

//      bottom navigation
        val bottomNavigation=binding.bottomNavigation
        bottomNavigation.setSelectedItemId(R.id.all_random)
        bottomNavigation.setOnNavigationItemSelectedListener(navigate)

//      play button for first game Roll a Dice
        binding.playButton1.setOnClickListener {
            val intent=Intent(this@AllGames,RollADice::class.java)
            startActivity(intent)
        }
//      play button for second game Flip a Coin
        binding.playButton2.setOnClickListener {
            val intent=Intent(this@AllGames,FlipACoin::class.java)
            startActivity(intent)
        }
//      play button for third game Pick a Tarot
        binding.playButton3.setOnClickListener {
            val intent=Intent(this@AllGames,PickTarotCard::class.java)
            startActivity(intent)
        }
//        play button to generate password
        binding.playButton4.setOnClickListener {
            val intent=Intent(this@AllGames,RandomPassword::class.java)
            startActivity(intent)
        }

    }
    private val navigate = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.all_random -> {
                return@OnNavigationItemSelectedListener false
            }
            R.id.home -> {
                val intent = Intent(this@AllGames, MainActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }
}
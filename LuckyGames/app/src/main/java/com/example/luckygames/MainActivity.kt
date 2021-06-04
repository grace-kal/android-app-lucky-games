package com.example.luckygames

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.luckygames.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mainRandomButton.setOnClickListener { randomNumber() }
        randomNumber()

        val bottomNavigation=binding.bottomNavigation
        bottomNavigation.setSelectedItemId(R.id.home)
        bottomNavigation.setOnNavigationItemSelectedListener(navigate)


    }
    private val navigate = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home -> {
                return@OnNavigationItemSelectedListener false
            }
            R.id.all_random -> {
                val intent = Intent(this@MainActivity, AllGames::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }
    @SuppressLint("ResourceAsColor")
    private fun randomNumber(){
        val randomNum:Int=(1..6).random()
        val resultView: TextView =binding.result
        resultView.text=randomNum.toString()
        when(randomNum){
            6->resultView.setTextColor(R.color.lucky_number);
        }
    }
}
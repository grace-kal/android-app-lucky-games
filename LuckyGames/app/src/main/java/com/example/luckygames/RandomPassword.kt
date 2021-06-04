package com.example.luckygames

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.luckygames.databinding.ActivityRandomPasswordBinding

class RandomPassword : AppCompatActivity() {
    lateinit var binding:ActivityRandomPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRandomPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        back button
        binding.backArrow.setOnClickListener{
            val intent= Intent(this@RandomPassword,AllGames::class.java)
            startActivity(intent)
        }
//        generate button
        binding.generateButton.setOnClickListener { generate() }
    }
    private fun generate(){
        val length=Integer.parseInt(binding.inputLength.text.toString())
        val specWord=binding.specialWordInput.text.toString()
        val pass=Password(length,specWord).generatePass()
        val passText: TextView =binding.generatedPass
        passText.text=pass
    }
}
class Password(private var length:Int,private val specialWord:String=""){

    private val source = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@&!#$+/=?"
    fun generatePass():String{
        if(length==0){
            length=8
        }
        val strBuild=StringBuilder(length)
        for(x in 0 until length){
            val random=(source.indices).random()
            strBuild.append(source[random])
        }
        strBuild.insert((0 until length).random(),specialWord)
        return strBuild.toString()
    }
}
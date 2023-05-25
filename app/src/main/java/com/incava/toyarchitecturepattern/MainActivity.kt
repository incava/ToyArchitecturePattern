package com.incava.toyarchitecturepattern

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.incava.toyarchitecturepattern.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // No Architecture
    val binding by lazy{ ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener { clickSave() }
        binding.btnLoadData.setOnClickListener { clickLoad() }
    }

    private fun clickSave(){
        val pref = getSharedPreferences("data", MODE_PRIVATE)
        pref.edit().apply{
            putString("name",binding.etName.text.toString())
            putString("email",binding.etEmail.text.toString())
        }.apply()
    }

    private fun clickLoad(){
        val pref = getSharedPreferences("data", MODE_PRIVATE)
        var name: String? = pref.getString("name","")
        var email: String = pref.getString("email","")!!
        binding.tvData.text = "name : ${name}\n email : ${email}"
    }
}
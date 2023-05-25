package com.incava.mvc.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.incava.mvc.databinding.ActivityMainBinding
import com.incava.mvc.model.Item
import com.incava.mvc.model.ItemModel

class MainActivity : AppCompatActivity() {
    val binding by lazy {  ActivityMainBinding.inflate(layoutInflater) }
    val itemModel by lazy { ItemModel(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnSave.setOnClickListener {
            itemModel.saveData(binding.etName.text.toString(),binding.etEmail.text.toString())
        }
        binding.btnLoadData.setOnClickListener {
            itemModel.loadData()
        }
    }

}
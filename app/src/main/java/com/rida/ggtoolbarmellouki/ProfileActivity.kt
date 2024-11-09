package com.rida.ggtoolbarmellouki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rida.ggtoolbarmellouki.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }
}
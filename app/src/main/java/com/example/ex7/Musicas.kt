package com.example.ex7

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ex7.databinding.ActivityLoginBinding
import com.example.ex7.databinding.ActivityMusicasBinding
import com.google.firebase.auth.FirebaseAuth

class Musicas : AppCompatActivity() {
    private lateinit var binding: ActivityMusicasBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {

        val user = FirebaseAuth.getInstance().currentUser
        if (user == null) {
            val intent1 = Intent(this, Musicas::class.java)
            intent1.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent1)
            return
        }
        binding = ActivityMusicasBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val artista = intent.getStringExtra("artist")
        if (artista == "Sewerslvt") {
            binding.titulo.text = "Sewerslvt - Best Songs"
            binding.songname1.text = "Swinging in His Cell"
            binding.imagesong1.setImageResource(R.drawable.dls)
            binding.songname2.text = "Goodbye"
            binding.imagesong2.setImageResource(R.drawable.goodtimes)
            binding.songname3.text = "Cyberia Lyr1"
            binding.imagesong3.setImageResource(R.drawable.lyr1)
        } else { //Cynthoni
            binding.titulo.text = "Cynthoni - Best Songs"
            binding.songname1.text = "Femcels"
            binding.imagesong1.setImageResource(R.drawable.dlsitoc)
            binding.songname2.text = "Long Division"
            binding.imagesong2.setImageResource(R.drawable.longdivision)
            binding.songname3.text = "Nine Red Squares"
            binding.imagesong3.setImageResource(R.drawable.cynpt2)
        }
        binding.back.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {

    }


    }

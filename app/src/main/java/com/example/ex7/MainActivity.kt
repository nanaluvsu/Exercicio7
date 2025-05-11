package com.example.ex7

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ex7.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth

    data class musga(val title: String, val duration: String)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var artistas = listOf(
            Artistas("1","Sewerslvt"),
            Artistas("2", "Cynthoni")
        )
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.imagealbum1.setOnClickListener{
           var intent = Intent(this@MainActivity, Musicas::class.java)
           intent.putExtra("artist","Sewerslvt")
           startActivity(intent)
        }
        binding.imagealbum2.setOnClickListener{
            var intent = Intent(this@MainActivity, Musicas::class.java)
            intent.putExtra("artist","Cynthoni")
            startActivity(intent)
        }
        }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {

    }
    }



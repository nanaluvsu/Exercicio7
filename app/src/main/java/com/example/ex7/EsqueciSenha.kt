package com.example.ex7

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ex7.databinding.ActivityEsqueciSenhaBinding
import com.google.firebase.auth.FirebaseAuth

class EsqueciSenha : AppCompatActivity() {
    private lateinit var binding: ActivityEsqueciSenhaBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEsqueciSenhaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance();
        binding.enviar.setOnClickListener{
            val email: String = binding.emailField.text.toString()
            if (email.isEmpty()) {
                Toast.makeText(this@EsqueciSenha,"Por favor, insira um e-mail.",Toast.LENGTH_SHORT).show()
            } else {
                firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener{ task ->
                    if (task.isSuccessful) {

                        Toast.makeText(this@EsqueciSenha,"E-mail enviado!",Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
            }
        }
        }

    }
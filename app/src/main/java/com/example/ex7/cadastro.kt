package com.example.ex7

import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ex7.databinding.ActivityCadastroBinding
import com.example.ex7.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class cadastro : AppCompatActivity() {
    private lateinit var binding:ActivityCadastroBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance();
        binding.button.setOnClickListener{
            val email = binding.emailField.text.toString()
            val senha = binding.senhaField.text.toString()

            if (email.isNotEmpty() && senha.isNotEmpty()) {
                firebaseAuth.createUserWithEmailAndPassword(email,senha).addOnCompleteListener{
                    if(it.isSuccessful) {
                        val intent = Intent(this, ActivityLoginBinding::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "ERRO: " + it.exception.toString() , Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "ERRO: Campos vazios.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
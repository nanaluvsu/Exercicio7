package com.example.ex7


import android.os.Bundle
import android.widget.Toast
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.ex7.databinding.ActivityCadastroBinding
import com.example.ex7.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, MainActivity::class.java)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance();
        binding.login.setOnClickListener{
            val email = binding.emailField.text.toString()
            val senha = binding.senhaField.text.toString()

            if (email.isNotEmpty() && senha.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email,senha).addOnCompleteListener{
                    if(it.isSuccessful) {

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
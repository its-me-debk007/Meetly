package com.vs.meetly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        hideDefaultUI()

        firebaseAuth = FirebaseAuth.getInstance()

        buttonRegister.setOnClickListener {
            registerUser()
        }
    }

//    TODO: Password Strong Progress Bar To Be Implemented

    private fun registerUser(){
        val email = etvEmail.text.toString()
        val password = etvPassword.text.toString()

//        TODO: To Check If The Below Function Can Be Called Using A Coroutine

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if(it.isSuccessful){
                    Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "Error, while creating user!", Toast.LENGTH_SHORT).show()
                }
            }
    }
    private fun hideDefaultUI(){
        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN)
    }
}
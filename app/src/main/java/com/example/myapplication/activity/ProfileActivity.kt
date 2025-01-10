package com.example.myapplication.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R

class ProfileActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)



        // Referencias a los elementos del layout
        val profileImage: ImageView = findViewById(R.id.profileImage)
        val profileName: EditText = findViewById(R.id.profileName)
        val profileEmail: EditText = findViewById(R.id.profileEmail)
        val profilePhone: EditText = findViewById(R.id.profilePhone)
        val profileAddress: EditText = findViewById(R.id.profileAddress)
        val saveButton: Button = findViewById(R.id.saveProfileButton)
        val backBtn:ImageView = findViewById(R.id.backBtn)



        backBtn.setOnClickListener{

            finish()


        }






        // Evento para guardar cambios
        saveButton.setOnClickListener {
            val name = profileName.text.toString()
            val email = profileEmail.text.toString()
            val phone = profilePhone.text.toString()
            val address = profileAddress.text.toString()

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty()) {
                Toast.makeText(this, "Por favor, rellena todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                // Aquí puedes guardar los datos en SharedPreferences, Firebase o una base de datos
                Toast.makeText(this, "Perfil guardado correctamente", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, MainActivity::class.java) // Cambia MainActivity por la actividad a la que deseas ir
                startActivity(intent)
            }
        }
    }







}

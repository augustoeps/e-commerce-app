package com.example.myapplication.activity

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.google.android.material.snackbar.Snackbar

class PurchaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_purchase)


        backBtn()

        val startBtn: AppCompatButton = findViewById(R.id.startBtn)
        startBtn.setOnClickListener{
            if (validateForm()) {
                val snackbar = Snackbar.make(
                    findViewById(android.R.id.content),
                    "Compra realizada correctamente",
                    Snackbar.LENGTH_INDEFINITE
                )
                    .setAction("Presiona aqui para confirmar,") {
                        // Cuando el usuario presione "OK", redirigir a MainActivity
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish() // Cerrar la actividad actual
                    }

                snackbar.show() // Mostrar el Snackbar

            }

        }


    }

    private fun backBtn() {

        val backImage: ImageView = findViewById(R.id.backBtn)

        backImage.setOnClickListener{

            finish()
        }
    }

    private fun validateForm(): Boolean {
        val name = findViewById<EditText>(R.id.nombre1).text.toString().trim()
        val lastName = findViewById<EditText>(R.id.apellido1).text.toString().trim()
        val email = findViewById<EditText>(R.id.correo1).text.toString().trim()
        val phone = findViewById<EditText>(R.id.telefono1).text.toString().trim()
        val address = findViewById<EditText>(R.id.direccion1).text.toString().trim()
        val cardNumber = findViewById<EditText>(R.id.tarjeta1).text.toString().trim()
        val expDate = findViewById<EditText>(R.id.fecha1).text.toString().trim()
        val cvv = findViewById<EditText>(R.id.cvv1).text.toString().trim()

        // Verificar si algún campo está vacío
        if (name.isEmpty() || lastName.isEmpty() || email.isEmpty() || phone.isEmpty() || address.isEmpty() || cardNumber.isEmpty() || expDate.isEmpty() || cvv.isEmpty()) {
            // Mostrar un mensaje si hay campos vacíos
            Toast.makeText(this, "Debe rellenar todos los campos", Toast.LENGTH_SHORT).show()
            return false // Retornar false si hay campos vacíos
        }

        return true // Retornar true si todos los campos están llenos
    }


}
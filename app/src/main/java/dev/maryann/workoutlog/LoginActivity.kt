package dev.maryann.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    lateinit var btnLogin:Button
    lateinit var tilEmail: TextInputLayout
    lateinit var tilPassword: TextInputLayout
    lateinit var txtEmail:TextInputEditText
    lateinit var txtPassword:TextInputEditText
    lateinit var tvSignUp:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin = findViewById(R.id.btnLogin)
        tilEmail=findViewById(R.id.tilEmail)
        tilPassword=findViewById(R.id.tilPassword)
        txtEmail=findViewById(R.id.txtEmail)
        txtPassword=findViewById(R.id.txtPassword)
        tvSignUp=findViewById(R.id.tvLogIn)
        tvSignUp.setOnClickListener {
//            val intent=Intent(this,SignUpActivity::class.java)
//            startActivity(intent)
            val intent=Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }




        btnLogin.setOnClickListener {
            validatelogin()
        }
    }


    fun validatelogin() {
//        var error = false
        tilEmail.error = null
        tilPassword.error = null
        var password=txtPassword.text.toString()
        var error=false

        var email = txtEmail.text.toString()
        if (email.isBlank()) {
            tilEmail.error = "Error is required "
            error = true


        }

//        var password = txtPassword.text.toString()
        if(password.isBlank()){
            tilPassword.error="Password is required"
            error=true
        }
        if(!error){

        }
    }
}




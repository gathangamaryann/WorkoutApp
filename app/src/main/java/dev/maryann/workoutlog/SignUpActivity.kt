package dev.maryann.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
    lateinit var txtEmail: TextInputEditText
    lateinit var tilEmail:TextInputLayout
    lateinit var btnSignUp: Button
    lateinit var txtPassword: TextInputEditText

    lateinit var txtFirstName: TextInputEditText
    lateinit var txtLastName: TextInputEditText
    lateinit var tilFirstName: TextInputLayout
    lateinit var tilLastName: TextInputLayout
    lateinit var tilPassword: TextInputLayout
    lateinit var tilConfirm: TextInputLayout
    lateinit var txtConfirm: TextInputEditText
    lateinit var tvLogIn:TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        btnSignUp= findViewById(R.id.btnSignUp)
        txtEmail = findViewById(R.id.txtEmail)
        txtPassword = findViewById(R.id.txtPassword)
        tilFirstName = findViewById(R.id.tilFirstName)
        tilPassword=findViewById(R.id.tilPassword)
        tilLastName = findViewById(R.id.tilLastName)
        tilConfirm = findViewById(R.id.tilConfirm)
        txtConfirm = findViewById(R.id.txtConfirm)

        txtLastName= findViewById(R.id.txtLastName)
        txtFirstName=findViewById(R.id.txtFirstName)
        tilEmail=findViewById(R.id.tilEmail)
        tvLogIn=findViewById(R.id.tvLogIn)


        tvLogIn.setOnClickListener {
            val intent=Intent(this,LoginActivity::class.java)
            startActivity((intent))
        }
        btnSignUp.setOnClickListener {
            validateSignUp()
        }

    }


    fun validateSignUp() {
        var error = false
        tilEmail.error = null
        tilPassword.error = null
        tilFirstName.error=null
        tilLastName.error=null
        tilConfirm.error=null
        var email = txtEmail.text.toString()
        if (email.isBlank()) {
            tilEmail.error = "Error is required "
            error = true


        }
        var first=txtFirstName.text.toString()
        if (first.isBlank()) {
            tilFirstName.error = "First name is required"
            error = true
        }
        var last=txtLastName.text.toString()
        if (last.isBlank()) {
            tilLastName.error = "Last name is required"
            error = true
        }

        var password=txtPassword.text.toString()

        if (password.isBlank()) {
            tilPassword.error = "Password is required"
            error = true

        }
        var confirm=txtConfirm.text.toString()
        if (confirm.isBlank()) {
            tilConfirm.error = "Confirm Password"
            error = true

        }
        if (!error){

        }
    }



}


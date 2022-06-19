package dev.maryann.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.maryann.workoutlog.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        binding= ActivitySignUpBinding.inflate(layoutInflater)



      binding.tvSignUp.setOnClickListener {
            val intent=Intent(this,LoginActivity::class.java)
            startActivity((intent))
        }
       binding. btnSignUp.setOnClickListener {
            validateSignUp()
        }

    }


    fun validateSignUp() {
        var error = false
      binding.txtEmail.error = null
      binding.tilPassword.error = null
       binding.tilFirstName.error=null
       binding.tilConfirm.error=null
        var email =binding.txtEmail.text.toString()
        if (email.isBlank()) {
           binding.tilEmail.error = "Error is required "
            error = true


        }
        var first=binding.txtFirstName.text.toString()
        if (first.isBlank()) {
          binding.tilFirstName.error = "First name is required"
            error = true
        }
        var last=binding.txtLastName.text.toString()
        if (last.isBlank()) {
           binding. tilLastName.error = "Last name is required"
            error = true
        }

        var password=binding.txtPassword.text.toString()

        if (password.isBlank()) {
           binding.tilPassword .error = "Password is required"
            error = true

        }
        var confirm=binding.txtConfirm.text.toString()
        if (confirm.isBlank()) {
            binding.tilConfirm.error = "Confirm Password"
            error = true

        }
        if (!error){

        }
    }



}


package dev.maryann.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.maryann.workoutlog.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

      binding.tvSignup.setOnClickListener {
//            val intent=Intent(this,SignUpActivity::class.java)
//            startActivity(intent)
            val intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
          finish()
        }



       binding.btnLogin.setOnClickListener {
            validatelogin()
           val intent=Intent(this,HomeActivity::class.java)
           startActivity(intent)
           finish()
        }
    }


    fun validatelogin() {
//        var error = false
        binding.tilEmail.error = null
       binding. tilPassword.error = null
        var password=binding.txtPassword.text.toString()
        var error=false

        var email = binding.txtEmail.text.toString()
        if (email.isBlank()) {
          binding.tilEmail.error = "Error is required "
            error = true


        }

//        var password = txtPassword.text.toString()
        if(password.isBlank()){
          binding.tilPassword.error="Password is required"
            error=true
        }
        if(!error){

        }
    }
}




package dev.maryann.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import android.database.Observable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.maryann.workoutlog.R
import dev.maryann.workoutlog.databinding.ActivitySignUpBinding
import dev.maryann.workoutlog.models.RegisterRequest
import dev.maryann.workoutlog.models.RegisterResponse
import dev.maryann.workoutlog.api.ApiClient
import dev.maryann.workoutlog.api.ApiInterface
import dev.maryann.workoutlog.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    val userViewModel: UserViewModel by viewModels()
    lateinit var sharedPrefs: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPrefs=getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {
            validateSignup()

        }
        binding.tvSignUp.setOnClickListener {
            val intent=Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        userViewModel.registerResponseLiveData.observe(this, Observer { registerResponse->
            Toast.makeText(baseContext,registerResponse?.message,Toast.LENGTH_LONG).show()
            startActivity(Intent(this@SignupActivity,LoginActivity::class.java))
        })
        userViewModel.registerErrorLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })
    }



    fun validateSignup() {
        var name = binding.txtFirstName.text.toString()
        var second = binding.txtLastName.text.toString()
        var phone = binding.txtphoneNumber.text.toString()
        var email = binding.txtEmail.text.toString()
        var error = false
        if (name.isBlank()) {
            binding.tilFirstName.error = "Firstname required"
        }
        if (second.isBlank()) {
            binding.tilLastName.error = "second name required"

        }
        if (phone.isBlank()) {
            binding.tilphonenumber.error = "Phone number required"

        }
        if (email.isBlank()) {
            binding.tilEmail.error = "Email reuired"
        }


        var confirm = binding.txtConfirm.text.toString()
        var password = binding.txtPassword.text.toString()
        if (confirm.isBlank()) {
            binding.tilConfirm.error = "confirm password"
        } else {
            binding.tilConfirm.error = null

        }
        if (password.isBlank()) {
            binding.tilPassword.error = "enter password"
        }
        if (confirm == password) {
            binding.btnSignUp
        } else {
            binding.tilConfirm.error = "invalid password"
        }
        if (!error) {
            val registerRequests = RegisterRequest(name, second, email, phone, password)
            userViewModel.registeruser(registerRequests)

        }


    }


}



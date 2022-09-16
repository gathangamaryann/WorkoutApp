package dev.maryann.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.maryann.workoutlog.databinding.ActivityLoginBinding
import dev.maryann.workoutlog.models.LoginRequest
import dev.maryann.workoutlog.models.LoginResponse
import dev.maryann.workoutlog.api.ApiClient
import dev.maryann.workoutlog.api.ApiInterface
import dev.maryann.workoutlog.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    lateinit var sharedPrefs:SharedPreferences
    val userViewModel:UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefs=getSharedPreferences("WORKOUT_PREFS", MODE_PRIVATE)

      binding.tvSignup.setOnClickListener {
//            val intent=Intent(this,SignUpActivity::class.java)
//            startActivity(intent)
            val intent=Intent(this, SignUpActivity::class.java)
            startActivity(intent)
          finish()
        }




       binding.btnLogin.setOnClickListener {
            validatelogin()
//           val intent=Intent(this, HomeActivity::class.java)
//           startActivity(intent)
//           finish()
        }
    }

    override fun onResume(){
        super.onResume()
        userViewModel.loginResponseliveData.observe(this, Observer{loginResponse->
            saveLoginDetails(loginResponse!!)
            Toast.makeText(baseContext,loginResponse?.message,Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext,HomeActivity::class.java))
            finish()
        })
        userViewModel.loginErrorLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()

        })
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

            var password = binding.txtPassword.text.toString()
            if(password.isBlank()){
                binding.tilPassword.error="Password is required"
                error=true
            }

            if(!error){
                var loginRequest=LoginRequest(email,password)
                binding.pbLogin.visibility=View.VISIBLE
                userViewModel.loginUser(loginRequest)
        }


        }
    }


    fun saveLoginDetails(loginResponse: LoginResponse){
        val editor=sharedPrefs.edit()
        editor.putString("ACCESS_TOKEN",loginResponse.accessToken)
        editor.putString("USER_ID",loginResponse.userId)
        editor.putString("PROFILE_ID",loginResponse.profileId)
        editor.apply()




    }
}




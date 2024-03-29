package dev.maryann.workoutlog.ui

import android.content.Context
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
import dev.maryann.workoutlog.utilities.Constants
import dev.maryann.workoutlog.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPrefs:SharedPreferences
    val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPrefs=getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)


        binding.btnLogin.setOnClickListener {
            validateLogin()
            finish()


        }

        binding.tvSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        userViewModel.loginResponseLiveData.observe(this, Observer { loginRespone->
            saveLoginDetails(loginRespone!!)
            Toast.makeText(baseContext,loginRespone?.message,Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext,HomeActivity::class.java))
            finish()
        })
        userViewModel.loginErrorLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })
    }

    fun validateLogin() {
        var email = binding.txtEmail.text.toString()
        var password = binding.txtPassword.text.toString()
        var error = false
        if (email.isBlank()) {
            binding.tilEmail.error = "password required"
            error = true
        }
        if (password.isBlank()) {
            binding.tilPassword.error = "password required"
            error = true
        }

        if (!error) {
            var loginrequests = LoginRequest(email, password)
//            binding.progressBar.visibility=View.VISIBLE
            userViewModel.loginUser(loginrequests)


        }
    }




    fun saveLoginDetails(loginResponse: LoginResponse){
        val editor=sharedPrefs.edit()
        val token = "Bearer ${loginResponse.accessToken}"
        editor.putString(Constants.accesstoken,token)
        editor.putString(Constants.userId,loginResponse.userId)
        editor.putString(Constants.proFileId,loginResponse.profileId)
        editor.apply()


    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }

    }
}







package dev.maryann.workoutlog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.maryann.workoutlog.R
import dev.maryann.workoutlog.databinding.ActivitySignUpBinding
import dev.maryann.workoutlog.models.RegisterRequest
import dev.maryann.workoutlog.models.RegisterResponse
import dev.maryann.workoutlog.api.ApiClient
import dev.maryann.workoutlog.api.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding





    override fun onResume(){
        super.onResume()
        setContentView(R.layout.activity_sign_up)
        binding= ActivitySignUpBinding.inflate(layoutInflater)



      binding.tvSignUp.setOnClickListener {
            val intent=Intent(this, LoginActivity::class.java)
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
            val registerRequest=RegisterRequest("Mary","Gathanga","marygathanga@gmail.com","0742277565","mary2000")
          makeRegisterationRequest(registerRequest)
        }

    }
    fun makeRegisterationRequest(registerRequest: RegisterRequest){
        var apiClient=ApiClient.buildApiClient(ApiInterface::class.java)
        var request=apiClient.registerUser(registerRequest)

        request.enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful){
                    var message=response.body()?.message
                    Toast.makeText(baseContext,message,Toast.LENGTH_LONG).show()
                    //intent to login

                }else{
                    val error=response.errorBody()?.string()
                    Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()

                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()


            }
        })

    }









}


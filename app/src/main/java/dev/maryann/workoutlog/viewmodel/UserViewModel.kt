package dev.maryann.workoutlog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.maryann.workoutlog.models.LoginRequest
import dev.maryann.workoutlog.models.LoginResponse
import dev.maryann.workoutlog.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel :ViewModel(){
    val userRepository=UserRepository()
    var loginResponseliveData=MutableLiveData<LoginResponse>()
    val loginErrorLiveData = MutableLiveData<String?>()

    fun loginUser(loginRequest: LoginRequest){
        viewModelScope.launch {
            val response=userRepository.loginUser(loginRequest)
            if (response.isSuccessful){
                loginResponseliveData.postValue(response.body())
            }
            else{
                val error=response.errorBody()?.string()
                loginErrorLiveData.postValue(error)
            }
        }
    }
}
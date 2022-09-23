package dev.maryann.workoutlog.repository

import dev.maryann.workoutlog.api.ApiClient
import dev.maryann.workoutlog.api.ApiInterface
import dev.maryann.workoutlog.models.LoginRequest
import dev.maryann.workoutlog.models.ProfileRequest
import dev.maryann.workoutlog.models.RegisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
class UserRepository {
    val apiClient=ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun loginUser(loginRequest: LoginRequest)= withContext(Dispatchers.IO){
        val response=apiClient.login(loginRequest)
        return@withContext response
    }


    suspend fun registerUser(registerRequets: RegisterRequest)= withContext(Dispatchers.IO){
        val response=apiClient.registerUser(registerRequets)
        return@withContext response
    }

    suspend fun profileUser(profileRequest: ProfileRequest)= withContext(Dispatchers.IO){
        val response=apiClient.profile(profileRequest)
        return@withContext response
    }
}
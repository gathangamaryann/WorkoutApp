package dev.maryann.workoutlog.api

import dev.maryann.workoutlog.models.LoginRequest
import dev.maryann.workoutlog.models.LoginResponse
import dev.maryann.workoutlog.models.RegisterRequest
import dev.maryann.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Body


interface ApiInterface{
    @POST("/register")
    fun registerUser(@Body registerRequest: RegisterRequest): Call<RegisterResponse>
    @POST("/login")
     suspend fun login(@Body loginRequest: LoginRequest):Response<LoginResponse>
}
package dev.maryann.workoutlog.api

import dev.maryann.workoutlog.models.*
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header


interface ApiInterface {
    @POST("/register")
    suspend fun registerUser(@Body registerRequest: RegisterRequest):Response<RegisterResponse>

    @POST ("/login")
    suspend fun login(@Body loginRequest: LoginRequest):Response<LoginResponse>

    @POST ("/profile")
    suspend fun profile(@Body profileRequest: ProfileRequest):Response<ProfileResponse>



    @GET("/exercise-categories")
    suspend fun fetchExerciseCategories(@Header("Authorization")acccessToken:String):Response<List<ExerciseCategory>>

}
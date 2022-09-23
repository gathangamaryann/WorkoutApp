package dev.maryann.workoutlog.repository

import dev.maryann.workoutlog.api.ApiClient
import dev.maryann.workoutlog.api.ApiInterface
import dev.maryann.workoutlog.models.LoginRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class ExerciseRespository {
    val apiClient=ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun  fetchExercisesCategories(accessToken:String)= withContext(Dispatchers.IO){

        return@withContext apiClient.fetchExerciseCategories(accessToken)

    }
}
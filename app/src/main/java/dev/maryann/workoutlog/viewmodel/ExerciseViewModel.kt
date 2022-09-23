package dev.maryann.workoutlog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.maryann.workoutlog.models.ExerciseCategory
import dev.maryann.workoutlog.repository.ExerciseRespository
import kotlinx.coroutines.launch

class ExerciseViewModel :ViewModel(){
    val exerciseRespository=ExerciseRespository()
    val exerciseCategoryLiveData=MutableLiveData<List<ExerciseCategory>>()
    val errorLiveData= MutableLiveData<String?>()

    fun fetchExerciseCategory(accessToken:String){
        viewModelScope.launch {
            val response=exerciseRespository.fetchExercisesCategories(accessToken)
            if(response.isSuccessful){
                exerciseCategoryLiveData.postValue((response.body()))
            }
            else{
                val errorMsg=response.errorBody()?.string()
                errorLiveData.postValue(errorMsg)
            }
        }

    }
}
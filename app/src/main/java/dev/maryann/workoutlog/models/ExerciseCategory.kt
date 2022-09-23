package dev.maryann.workoutlog.models

import com.google.gson.annotations.SerializedName

data class ExerciseCategory(
    @SerializedName("categoryId")var categoryId:String,
    @SerializedName("categoryName")var categoryName:String

)

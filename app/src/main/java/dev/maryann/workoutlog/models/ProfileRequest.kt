package dev.maryann.workoutlog.models

data class ProfileRequest(
    var gender:String,
    var weight:String,
    var height:String,
    var dateOfBirth:String
)
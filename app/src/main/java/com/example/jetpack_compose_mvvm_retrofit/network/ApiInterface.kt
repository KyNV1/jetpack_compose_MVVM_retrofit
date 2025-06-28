package com.example.jetpack_compose_mvvm_retrofit.network

import com.example.jetpack_compose_mvvm_retrofit.model.User
import retrofit2.http.GET

interface ApiInterface {
    @GET("todos")
    suspend fun getUserData():List<User>
}
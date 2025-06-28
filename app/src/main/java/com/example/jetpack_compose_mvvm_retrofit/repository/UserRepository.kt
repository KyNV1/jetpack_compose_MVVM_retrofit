package com.example.jetpack_compose_mvvm_retrofit.repository

import com.example.jetpack_compose_mvvm_retrofit.model.User
import com.example.jetpack_compose_mvvm_retrofit.network.ApiInterface
import com.example.jetpack_compose_mvvm_retrofit.utils.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class UserRepository @Inject constructor(
    private val apiInterface: ApiInterface
) {
    suspend fun getUser(): Resource<List<User>> {
        val response = try {
            apiInterface.getUserData()
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured")
        }
        return Resource.Success(response)
    }
}

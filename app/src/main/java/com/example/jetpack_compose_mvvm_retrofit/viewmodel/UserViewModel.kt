package com.example.jetpack_compose_mvvm_retrofit.viewmodel

import androidx.lifecycle.ViewModel
import com.example.jetpack_compose_mvvm_retrofit.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) :ViewModel() {

}
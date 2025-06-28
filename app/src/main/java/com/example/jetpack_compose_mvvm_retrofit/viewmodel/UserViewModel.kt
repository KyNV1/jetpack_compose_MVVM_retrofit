package com.example.jetpack_compose_mvvm_retrofit.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpack_compose_mvvm_retrofit.model.User
import com.example.jetpack_compose_mvvm_retrofit.repository.UserRepository
import com.example.jetpack_compose_mvvm_retrofit.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    init {
        viewModelScope.launch {
            getUsers()
        }
    }
    var isLoading = mutableStateOf(false)
    private var _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>>
        get() = _users

    private suspend fun getUsers(): Resource<List<User>> {
        var result = userRepository.getUser()
        if (result is Resource.Success) {
            isLoading.value = true
            _users.value = result.data!!
        }
        return result
    }

}
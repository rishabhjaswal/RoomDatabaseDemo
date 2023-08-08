package com.roomdatabase.ViewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.roomdatabase.Model.User
import com.roomdatabase.Repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class UserViewModel
@ViewModelInject
constructor(private val userRepository: UserRepository) : ViewModel(){
    val getUser:LiveData<List<User>> get() =
        userRepository.getUser.flowOn(Dispatchers.Main)
            .asLiveData(context = viewModelScope.coroutineContext)

    fun insert(user: User){
        viewModelScope.launch {
            userRepository.insert(user)
        }
    }
}
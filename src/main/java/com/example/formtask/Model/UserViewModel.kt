package com.example.formtask.Model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {

    val readAllData: LiveData<List<User>>
    private val repository: UserRepo

    init {
        val userDao = UserDB.getDatabase(application).userDao()
        repository =UserRepo(userDao)
        readAllData = repository.readAllData

    }

    fun addUser(user: User){

        viewModelScope.launch(Dispatchers.IO){repository.addUser(user) }
    }

}
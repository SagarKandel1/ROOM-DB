package com.example.formtask.Model

import androidx.lifecycle.LiveData

class UserRepo (private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()

        suspend fun addUser(user: User){
            userDao.addUser(user)
    }
}



package com.roomdatabase.Repository

import androidx.annotation.WorkerThread
import com.roomdatabase.Dao.UserDao
import com.roomdatabase.Model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepository @Inject constructor (private val userDao: UserDao) {
    val getUser:Flow<List<User>> = userDao.getUser()

    @WorkerThread
    suspend fun insert(user: User) = withContext(Dispatchers.IO){
        userDao.insert(user)
    }
}
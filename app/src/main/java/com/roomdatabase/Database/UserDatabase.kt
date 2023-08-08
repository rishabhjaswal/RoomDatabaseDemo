package com.roomdatabase.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.roomdatabase.Dao.UserDao
import com.roomdatabase.Model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao

    }

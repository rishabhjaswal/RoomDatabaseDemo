package com.roomdatabase.di

import android.content.Context
import androidx.room.Room
import com.roomdatabase.Dao.UserDao
import com.roomdatabase.Database.UserDatabase
import com.roomdatabase.Repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule  {

    @Provides
    fun providesUserDao(userDatabase: UserDatabase): UserDao = userDatabase.userDao()

    @Provides
    @Singleton
    fun providesUserDatabase(@ApplicationContext context: Context): UserDatabase
            = Room.databaseBuilder(context, UserDatabase::class.java,"UserDatabase").build()

    @Provides
    fun providesUserRepository(userDao: UserDao) : UserRepository
            = UserRepository(userDao)
}
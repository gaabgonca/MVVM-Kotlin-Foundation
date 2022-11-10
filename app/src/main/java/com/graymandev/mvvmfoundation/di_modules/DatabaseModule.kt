package com.graymandev.mvvmfoundation.di_modules

import android.content.Context
import androidx.room.Room
import com.graymandev.mvvmfoundation.model.database.AppDatabase
import com.graymandev.mvvmfoundation.model.database.TimeRecordsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    fun provideTimeRecordsDao(appDatabase: AppDatabase) : TimeRecordsDao {
        return appDatabase.timeRecordsDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "RssReader"
        ).build()
    }
}
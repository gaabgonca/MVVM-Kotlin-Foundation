package com.graymandev.mvvmfoundation.model.repository

import com.graymandev.mvvmfoundation.model.database.TimeRecordsDao
import com.graymandev.mvvmfoundation.model.database.entities.TimeRecord
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Date
import javax.inject.Inject

//This class uses an injected DAO to perform operations on database
class TimeRecordsRepository @Inject constructor(private val timeRecordsDao: TimeRecordsDao, private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO) {

    // Gets records from database
    suspend fun getAllRecords() : List<TimeRecord> {
       return withContext(defaultDispatcher){
            timeRecordsDao.getAll()
        }

    }

    //Creates a record from a date
    suspend fun addRecord(date: Date) {
        val timeRecord = TimeRecord(date.toInstant().nano,date.toString())
        withContext(defaultDispatcher){
            timeRecordsDao.addRecord(timeRecord)
        }

    }

    //Deletes all timerecords
     suspend fun deleteAllRecords() {
        withContext(defaultDispatcher) {
            timeRecordsDao.deleteAll()
        }
    }
}
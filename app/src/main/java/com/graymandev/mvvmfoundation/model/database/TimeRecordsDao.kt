package com.graymandev.mvvmfoundation.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.graymandev.mvvmfoundation.model.database.entities.TimeRecord

@Dao
interface TimeRecordsDao {

    @Query("SELECT * FROM records")
    fun getAll() : List<TimeRecord>

    @Insert
    fun addRecord(record: TimeRecord)

    @Query("DELETE FROM records")
    fun deleteAll()

}
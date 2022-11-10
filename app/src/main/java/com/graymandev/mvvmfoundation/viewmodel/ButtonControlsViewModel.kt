package com.graymandev.mvvmfoundation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.graymandev.mvvmfoundation.model.database.entities.TimeRecord
import com.graymandev.mvvmfoundation.model.repository.TimeRecordsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

typealias MyCallback = () -> Unit


@HiltViewModel
class ButtonControlsViewModel @Inject constructor() : ViewModel() {

    @Inject lateinit var timeRecordsRepository: TimeRecordsRepository

    //The private one is mutable, can be changed inside the viewmodel
    private val _timeRecordsLiveData = MutableLiveData<List<TimeRecord>>()

    //The public one is not mutable, this is the one we observe in UI
    val timeRecordsLiveData : LiveData<List<TimeRecord>> = _timeRecordsLiveData



    fun recordNow(callback: MyCallback) {
        val now = Date() //New date object without arguments returns the current datetime
        viewModelScope.launch {
            timeRecordsRepository.addRecord(now)
            callback()
        }

    }

     fun deleteAllRecords(callback: MyCallback) {
         viewModelScope.launch {
            timeRecordsRepository.deleteAllRecords()
             _timeRecordsLiveData.postValue(listOf())
             callback()
        }
    }

     fun getAllRecords() {
         viewModelScope.launch {
            val allRecords = timeRecordsRepository.getAllRecords()
             for (record in allRecords){
                 println(record.dateTime.toString())
             }
            _timeRecordsLiveData.postValue(allRecords)
        }

    }
}
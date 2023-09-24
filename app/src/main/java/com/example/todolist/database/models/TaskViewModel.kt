package com.example.todolist.database.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.todolist.database.AppDatabase
import com.example.todolist.database.repository.TaskRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application){

    val readTasks : LiveData<List<TaskModel>>
    private val repository: TaskRepository

    init {
        val taskDao =AppDatabase.getDatabase(application).taskDao()
        repository = TaskRepository(taskDao)
        readTasks =repository.allTasks
    }

    fun addTask(task: TaskModel){
        CoroutineScope(Dispatchers.IO).launch {
            repository.addTask(task)
        }
    }

    fun deleteTask(task: TaskModel){
        CoroutineScope(Dispatchers.IO).launch {
            repository.deleteTask(task)
        }
    }

}
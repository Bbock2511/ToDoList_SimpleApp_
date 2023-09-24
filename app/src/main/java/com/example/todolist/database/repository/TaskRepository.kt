package com.example.todolist.database.repository

import androidx.lifecycle.LiveData
import com.example.todolist.database.daos.TaskDao
import com.example.todolist.database.models.TaskModel

class TaskRepository(private val taskDao: TaskDao) {
    val allTasks: LiveData<List<TaskModel>> = taskDao.getAllTasks()

    fun deleteTask(task: TaskModel){
        taskDao.deleteTask(task)
    }

    fun addTask(task: TaskModel){
        taskDao.insert(task)
    }
}
package com.example.todolist.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.todolist.database.models.TaskModel

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(task: TaskModel)

    @Query("SELECT * FROM TaskModel")
    fun getAllTasks():LiveData<List<TaskModel>>

    @Delete
    fun deleteTask(task: TaskModel)

    @Update
    fun update(vararg task: TaskModel)

    @Query("SELECT COUNT(id) FROM TaskModel")
    fun getTotalItems():Long

}
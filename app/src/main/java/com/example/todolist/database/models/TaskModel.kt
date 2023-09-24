package com.example.todolist.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity
data class TaskModel(
    @PrimaryKey(autoGenerate = true) var id:Int = 0,
    @ColumnInfo(name = "task") val task: String
)


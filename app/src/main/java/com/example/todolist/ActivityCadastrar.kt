package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.database.AppDatabase
import com.example.todolist.database.daos.TaskDao
import com.example.todolist.database.models.TaskModel
import com.example.todolist.database.models.TaskViewModel
import com.example.todolist.databinding.ActivityCadastrarBinding

class ActivityCadastrar : AppCompatActivity() {

    private lateinit var binding: ActivityCadastrarBinding
    private lateinit var database: AppDatabase
    private lateinit var taskDao: TaskDao
    private lateinit var mTaskViewModel: TaskViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastrarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = AppDatabase.getDatabase(this)

        taskDao = database.taskDao()

        mTaskViewModel = ViewModelProvider(this)[TaskViewModel::class.java]

        binding.buttonConfirmar.setOnClickListener {
            insertTask()
        }
    }
    private fun insertTask() {
        val taskText = binding.taskEditText.text.toString()

        if (taskValidation(taskText)) {
            val task = TaskModel(0, taskText)
            mTaskViewModel.addTask(task)
            Toast.makeText(this, "Task adicionada!", Toast.LENGTH_LONG).show()
            val getTaskListActivity = Intent(this, MainActivity::class.java)
            startActivity(getTaskListActivity)
        }
    }
    private fun taskValidation(task: String): Boolean {
        return task.isNotEmpty()
    }
}

package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.adapter.AdapterTaskView
import com.example.todolist.database.models.TaskViewModel
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mTaskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mTaskViewModel = ViewModelProvider(this)[TaskViewModel::class.java]

        val adapterTasks = AdapterTaskView(mTaskViewModel)
        val recyclerView = binding.tasksView
        recyclerView.adapter = adapterTasks
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)


        mTaskViewModel = ViewModelProvider(this)[TaskViewModel::class.java]
        mTaskViewModel.readTasks.observe(this) { task ->
            adapterTasks.setData(task)
        }

        binding.floatingActionButton.setOnClickListener {
            val getSubmitTaskActivity = Intent(this, ActivityCadastrar::class.java)
            startActivity(getSubmitTaskActivity)
        }
    }
}
package com.example.todolist.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.database.daos.TaskDao
import com.example.todolist.database.models.TaskModel
import com.example.todolist.database.models.TaskViewModel
import com.example.todolist.databinding.TaskViewBinding

class AdapterTaskView(private val taskViewModel: TaskViewModel): RecyclerView.Adapter<AdapterTaskView.TaskViewHolder>() {

    private var taskList = emptyList<TaskModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemTask = TaskViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(itemTask)
    }

    override fun getItemCount() = taskList.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val currentTask = taskList[position]
        holder.taskView.text = taskList[position].task
        holder.deleteButton.setOnClickListener {
            taskViewModel.deleteTask(currentTask)
        }
    }

    class TaskViewHolder(binding: TaskViewBinding): RecyclerView.ViewHolder(binding.root) {
        val taskView = binding.textView
        val deleteButton = binding.deleteTask
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(taskModel: List<TaskModel>){
        this.taskList = taskModel
        notifyDataSetChanged()
    }


}

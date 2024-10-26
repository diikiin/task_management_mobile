package com.dikin.taskmanagement.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dikin.taskmanagement.R
import com.dikin.taskmanagement.data.Task

class TasksAdapter(private val tasks: List<Task>) :
    RecyclerView.Adapter<TasksAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val taskTitle = view.findViewById<TextView>(R.id.task_title)
        private val taskDescription = view.findViewById<TextView>(R.id.task_description)
        private val taskPriority = view.findViewById<TextView>(R.id.task_priority)

        @SuppressLint("SetTextI18n")
        fun bind(task: Task) {
            taskTitle.text = task.title
            taskDescription.text = "Description: ${task.description}"
            taskPriority.text = "Priority: ${task.priority}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_task_item, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    override fun getItemCount(): Int = tasks.size
}
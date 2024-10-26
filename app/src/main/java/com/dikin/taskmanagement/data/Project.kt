package com.dikin.taskmanagement.data

data class Project(
    val id: Int,
    val title: String,
    val description: String,
    private var _tasks: MutableList<Task>
) {
    val tasks get() = _tasks

    fun addTask(task: Task) {
        _tasks.add(task)
    }
}

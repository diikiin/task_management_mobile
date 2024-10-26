package com.dikin.taskmanagement.data

data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val priority: Priority,
    private var _isDone: Boolean = false
) {
    val isDone get() = _isDone

    fun markAsCompleted() {
        _isDone = true
    }
}

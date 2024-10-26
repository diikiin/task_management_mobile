package com.dikin.taskmanagement.data

object MockDataProvider {

    val tasks = getAllTasks()
    val projects = getProjects()
    private var taskId = 0

    private fun getProjects(): MutableList<Project> {
        return mutableListOf(
            Project(1, "Task Management", "Create simple task management project", getTasks1()),
            Project(2, "Instagram", "Crate simple instagram project", getTasks2())
        )
    }

    private fun getAllTasks(): MutableList<Task> {
        val tasks = mutableListOf<Task>()
        projects.forEach { p -> tasks.addAll(p.tasks) }
        return tasks
    }

    private fun getTasks1(): MutableList<Task> {
        return mutableListOf(
            Task(++taskId, "Create project", "Create simple android project", Priority.MEDIUM),
            Task(
                ++taskId,
                "Read kotlin documentation",
                "Improve knowledge about kotlin",
                Priority.LOW
            ),
            Task(
                ++taskId,
                "Write project report",
                "Write fully documented report about project",
                Priority.HIGH
            ),
        )
    }

    private fun getTasks2(): MutableList<Task> {
        return mutableListOf(
            Task(++taskId, "Create project", "Create simple android project", Priority.MEDIUM),
            Task(
                ++taskId,
                "Create home page",
                "Create home page with posts",
                Priority.LOW
            ),
            Task(
                ++taskId,
                "Create profile page",
                "Create profile page with user info and posts",
                Priority.HIGH
            ),
        )
    }
}
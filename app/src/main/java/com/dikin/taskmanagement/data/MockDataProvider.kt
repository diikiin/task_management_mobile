package com.dikin.taskmanagement.data

object MockDataProvider {

    val projects = getAllProjects()
    val tasks = getAllTasks()
    private var taskId = 1
    private var projectId = 1

    fun addProject(title: String, description: String) {
        val project = Project(projectId++, title, description, mutableListOf())
        projects.add(project)
    }

    fun addTask(title: String, description: String, priority: Priority, projectId: Int) {
        val task = Task(taskId++, title, description, priority)
        tasks.add(task)
        addTaskToProject(projectId, task)
    }

    private fun addTaskToProject(projectId: Int, task: Task) {
        val project = projects.find { it.id == projectId }
        project?.tasks?.add(task)
    }

    private fun getAllProjects(): MutableList<Project> {
        return mutableListOf(
            Project(projectId++, "Task Management", "Create simple task management project", getTasks1()),
            Project(projectId++, "Instagram", "Crate simple instagram project", getTasks2())
        )
    }

    private fun getAllTasks(): MutableList<Task> {
        val tasks = mutableListOf<Task>()
        getAllProjects().forEach { p -> tasks.addAll(p.tasks) }
        return tasks
    }

    private fun getTasks1(): MutableList<Task> {
        return mutableListOf(
            Task(taskId++, "Create project", "Create simple android project", Priority.MEDIUM),
            Task(
                taskId++,
                "Read kotlin documentation",
                "Improve knowledge about kotlin",
                Priority.LOW
            ),
            Task(
                taskId++,
                "Write project report",
                "Write fully documented report about project",
                Priority.HIGH
            ),
        )
    }

    private fun getTasks2(): MutableList<Task> {
        return mutableListOf(
            Task(taskId++, "Create project", "Create simple android project", Priority.MEDIUM),
            Task(
                taskId++,
                "Create home page",
                "Create home page with posts",
                Priority.LOW
            ),
            Task(
                taskId++,
                "Create profile page",
                "Create profile page with user info and posts",
                Priority.HIGH
            ),
        )
    }
}
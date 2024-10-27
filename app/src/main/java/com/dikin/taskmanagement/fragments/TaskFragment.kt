package com.dikin.taskmanagement.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.dikin.taskmanagement.R
import com.dikin.taskmanagement.adapters.TasksAdapter
import com.dikin.taskmanagement.data.MockDataProvider
import com.dikin.taskmanagement.data.Priority
import com.dikin.taskmanagement.data.Project
import com.dikin.taskmanagement.data.Task
import com.dikin.taskmanagement.databinding.FragmentTaskBinding

class TaskFragment : Fragment(R.layout.fragment_task) {

    private var _binding: FragmentTaskBinding? = null
    private val binding get() = _binding!!

    private lateinit var rv: RecyclerView
    private lateinit var tasks: List<Task>
    private lateinit var adapter: TasksAdapter
    private lateinit var addTask: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tasks = MockDataProvider.tasks
        rv = binding.taskRv
        adapter = TasksAdapter(tasks)
        rv.adapter = adapter
        addTask = binding.addTask

        addTask.setOnClickListener {
            showAddTaskDialog()
        }
    }

    private fun showAddTaskDialog() {
        val dialogView = layoutInflater.inflate(R.layout.add_task, null)
        val titleInput = dialogView.findViewById<EditText>(R.id.add_task_title_et)
        val descriptionInput = dialogView.findViewById<EditText>(R.id.add_task_description_et)
        val prioritySpinner = dialogView.findViewById<Spinner>(R.id.add_task_priority_spinner)
        val projectsSpinner = dialogView.findViewById<Spinner>(R.id.add_task_projects_spinner)

        val projects = MockDataProvider.projects
        val projectTitles = projects.map { it.title }
        val projectIds = projects.map { it.id }

        prioritySpinner.adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            Priority.entries.toTypedArray()
        )

        projectsSpinner.adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            projectTitles
        )

        AlertDialog.Builder(requireContext())
            .setTitle("Add Task")
            .setView(dialogView)
            .setPositiveButton("Add") { _, _ ->
                val title = titleInput.text.toString()
                val description = descriptionInput.text.toString()
                val priority = prioritySpinner.selectedItem as Priority
                val projectId = projectIds[projectsSpinner.selectedItemPosition]

                MockDataProvider.addTask(title, description, priority, projectId)
                adapter.notifyDataSetChanged()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}
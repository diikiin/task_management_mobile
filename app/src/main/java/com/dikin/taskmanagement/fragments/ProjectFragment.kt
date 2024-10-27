package com.dikin.taskmanagement.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dikin.taskmanagement.R
import com.dikin.taskmanagement.adapters.ProjectsAdapter
import com.dikin.taskmanagement.data.MockDataProvider
import com.dikin.taskmanagement.data.Project
import com.dikin.taskmanagement.databinding.FragmentProjectBinding

class ProjectFragment : Fragment(R.layout.fragment_project) {

    private var _binding: FragmentProjectBinding? = null
    private val binding get() = _binding!!

    private lateinit var projects: List<Project>
    private lateinit var rv: RecyclerView
    private lateinit var adapter: ProjectsAdapter
    private lateinit var createProject: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProjectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        projects = MockDataProvider.projects
        rv = binding.projectRv
        adapter = ProjectsAdapter(projects) { project ->
            val action =
                ProjectFragmentDirections.actionProjectsFragmentToProjectDetailFragment(project.id)
            findNavController().navigate(action)
        }
        rv.adapter = adapter
        createProject = binding.createProject

        createProject.setOnClickListener {
            showCreateProjectDialog()
        }
    }

    private fun showCreateProjectDialog() {
        val dialogView = layoutInflater.inflate(R.layout.create_project, null)
        val titleInput = dialogView.findViewById<EditText>(R.id.create_project_title_et)
        val descriptionInput = dialogView.findViewById<EditText>(R.id.create_project_description_et)

        AlertDialog.Builder(requireContext())
            .setTitle("Add Task")
            .setView(dialogView)
            .setPositiveButton("Add") { _, _ ->
                val title = titleInput.text.toString()
                val description = descriptionInput.text.toString()

                MockDataProvider.addProject(title, description)
                adapter.notifyDataSetChanged()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}
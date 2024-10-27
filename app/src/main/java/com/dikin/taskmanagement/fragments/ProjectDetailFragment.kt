package com.dikin.taskmanagement.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.dikin.taskmanagement.R
import com.dikin.taskmanagement.adapters.TasksAdapter
import com.dikin.taskmanagement.data.MockDataProvider
import com.dikin.taskmanagement.databinding.FragmentProjectDetailBinding

class ProjectDetailFragment : Fragment(R.layout.fragment_project_detail) {

    private var _binding: FragmentProjectDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var projectTitle: TextView
    private lateinit var projectDescription: TextView
    private lateinit var tasksRv: RecyclerView
    private lateinit var adapter: TasksAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProjectDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        projectTitle = binding.projectDetailTitle
        projectDescription = binding.projectDetailDescription
        tasksRv = binding.projectDetailTasksRv

        val projectId = arguments?.let { ProjectDetailFragmentArgs.fromBundle(it).projectId }

        val project = MockDataProvider.projects[projectId!!]

        projectTitle.text = project.title
        projectDescription.text = project.description
        adapter = TasksAdapter(project.tasks)
        tasksRv.adapter = adapter
    }
}
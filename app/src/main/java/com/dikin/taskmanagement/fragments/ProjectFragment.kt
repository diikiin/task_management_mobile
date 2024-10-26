package com.dikin.taskmanagement.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
        adapter = ProjectsAdapter(projects)
        rv.adapter = adapter
    }
}
package com.dikin.taskmanagement.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.dikin.taskmanagement.R
import com.dikin.taskmanagement.adapters.TasksAdapter
import com.dikin.taskmanagement.data.MockDataProvider
import com.dikin.taskmanagement.data.Task
import com.dikin.taskmanagement.databinding.FragmentTaskBinding

class TaskFragment : Fragment(R.layout.fragment_task) {

    private var _binding: FragmentTaskBinding? = null
    private val binding get() = _binding!!

    private lateinit var rv: RecyclerView
    private lateinit var tasks: List<Task>
    private lateinit var adapter: TasksAdapter

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
    }
}
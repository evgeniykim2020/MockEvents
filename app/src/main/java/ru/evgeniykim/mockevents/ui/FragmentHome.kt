package ru.evgeniykim.mockevents.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.evgeniykim.mockevents.R
import ru.evgeniykim.mockevents.databinding.FragmentHomeBinding
import ru.evgeniykim.mockevents.ui.viewmodel.MainViewModel

class FragmentHome: Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
    }
}
package ru.evgeniykim.mockevents.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.evgeniykim.mockevents.R
import ru.evgeniykim.mockevents.databinding.FragmentDetailsBinding

class FragmentDetails: Fragment(R.layout.fragment_details) {
    private lateinit var binding: FragmentDetailsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailsBinding.bind(view)
    }
}
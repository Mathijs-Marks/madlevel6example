package com.example.madlevel6example.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.madlevel6example.R
import com.example.madlevel6example.databinding.FragmentTriviaBinding
import com.example.madlevel6example.viewmodel.TriviaViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class TriviaFragment : Fragment() {

    private val viewModel: TriviaViewModel by activityViewModels()
    private var _binding: FragmentTriviaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTriviaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeTrivia()
    }

    private fun observeTrivia() {
        viewModel.trivia.observe(viewLifecycleOwner, {
            binding.tvTrivia.text = it?.text
        })

        // Observe the error message.
        viewModel.errorText.observe(viewLifecycleOwner, {
            Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
        })
    }
}
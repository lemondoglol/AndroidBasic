package com.example.navigationexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {

    // setup viewModel
    private val myViewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // navigate to Detail Fragment
        view.findViewById<Button>(R.id.home_button).setOnClickListener {
            myViewModel.increaseCount()
            findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
        }

        // observe live data
        myViewModel.currentCount.observe(viewLifecycleOwner, {
            view.findViewById<TextView>(R.id.home_textView).text = it.toString()
        })

    }
}
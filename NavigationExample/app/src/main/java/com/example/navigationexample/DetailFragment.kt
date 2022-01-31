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

class DetailFragment : Fragment() {

    private val myViewModel by activityViewModels<MyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // navigate to Detail Fragment
        view.findViewById<Button>(R.id.detail_button).setOnClickListener {
            myViewModel.increaseCount()
            findNavController().navigate(R.id.action_detailFragment_to_homeFragment)
        }

        // observe live data
        myViewModel.currentCount.observe(viewLifecycleOwner, {
            view.findViewById<TextView>(R.id.detail_textView).text = it.toString()
        })
    }

}
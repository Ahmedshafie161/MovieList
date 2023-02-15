package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.myapplication.databinding.FragmentBlankBinding


class BlankFragment : Fragment(R.layout.fragment_blank) {

    lateinit var fragmentBlankBinding: FragmentBlankBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBlankBinding = FragmentBlankBinding.inflate(layoutInflater)
        return fragmentBlankBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentBlankBinding.button2.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_blankFragment_to_itemFragment)
        }
    }
}
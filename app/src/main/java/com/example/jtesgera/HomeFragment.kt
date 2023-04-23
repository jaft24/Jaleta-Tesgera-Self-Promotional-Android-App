package com.example.jtesgera

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.jtesgera.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    // Declare a binding lateinit variable to hold this Fragment
    private lateinit var binding: FragmentHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate this fragment using the binding var we declared above
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        // Implement an On Click Listener for the Home Page to Navigate to the Biography Fragment
        binding.BibHomeButton.setOnClickListener {
                it.findNavController().navigate(R.id.action_homeFragment_to_biographyFragment)
        }

        // Implement an On Click Listener for the Home Page to Navigate to the Project List Fragment
        binding.ProjHomeButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_projectListFragment)
        }

        // Implement an On Click Listener for the Home Page to Navigate to the Contact Me Fragment
        binding.ContactHomeButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_contactFragment)
        }

        // Implement an On Click Listener for the Home Page to Navigate to the Options(Settings) Fragment
        binding.OptionsHomeButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_optionsFragment)
        }


        // return the binding we declared above and keep on i.e. this Fragment if this buttons is not clicked.
        return binding.root

    }



}
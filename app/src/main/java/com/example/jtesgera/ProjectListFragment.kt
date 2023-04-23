package com.example.jtesgera

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.jtesgera.databinding.FragmentProjectListBinding

class ProjectListFragment : Fragment() {

    // Declare a binding lateinit variable to hold this Fragment
    private lateinit var binding: FragmentProjectListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate this fragment using the binding var we declared above
        binding = FragmentProjectListBinding.inflate(inflater,container,false)

        // Implement an On Click Listener for the First Project to Navigate to its Detail (New Roz Kebab Website)
        binding.projtoDetailNrk.setOnClickListener {
            it.findNavController().navigate(R.id.action_projectListFragment_to_newRozKebabFragment)
        }

        // Implement an On Click Listener for the Second Project to Navigate to its Detail (Breaking the Poverty Cycle of Agriculture)
        binding.projtoDetailBpca.setOnClickListener {
            it.findNavController().navigate(R.id.action_projectListFragment_to_breakingPovertyCycleFragment2)
        }

        // return the binding we declared above i.e. this Fragment if none of these buttons are clicked.
        return binding.root

    }


}
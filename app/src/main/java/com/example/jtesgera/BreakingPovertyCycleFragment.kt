package com.example.jtesgera

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.jtesgera.databinding.FragmentBreakingPovertyCycleBinding
import com.example.jtesgera.databinding.FragmentNewRozKebabBinding
import com.example.jtesgera.databinding.FragmentProjectListBinding

class BreakingPovertyCycleFragment : Fragment() {

    // Declare a binding lateinit variable to hold this Fragment
    private lateinit var binding: FragmentBreakingPovertyCycleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate this fragment using the binding var we declared above
        binding = FragmentBreakingPovertyCycleBinding.inflate(inflater,container,false)

        // Implement an On Click Listener for the Second Project to Navigate to the First Project (New Roz Kebab Website)
        binding.projDet2LoadNext.setOnClickListener {
            it.findNavController().navigate(R.id.action_breakingPovertyCycleFragment2_to_newRozKebabFragment)
        }

        // return the binding we declared above and keep on i.e. this Fragment if this buttons is not clicked.
        return binding.root
    }

}
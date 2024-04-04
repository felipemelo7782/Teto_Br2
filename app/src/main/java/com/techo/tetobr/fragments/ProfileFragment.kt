package com.techo.tetobr.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.techo.tetobr.R
import com.techo.tetobr.databinding.FragmentHomeBinding
import com.techo.tetobr.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private val TAG = "ProfileFragment"
    private var binding: FragmentProfileBinding? = null
    private var context: Context? = null
    private var shared: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Agora você pode acessar o contexto com segurança
        requireContext()
        // ...

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

        binding.let {

        }
    }
    companion object {

    }
}
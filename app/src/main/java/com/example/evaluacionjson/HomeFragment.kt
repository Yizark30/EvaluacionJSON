package com.example.evaluacionjson

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.evaluacionjson.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAgregar.setOnClickListener(){
            it.findNavController().navigate(R.id.hometoinsert)
        }
        binding.btnMostrar.setOnClickListener(){
            it.findNavController().navigate(R.id.hometoview)
        }

        binding.btnEditar.setOnClickListener {
            it.findNavController().navigate(R.id.homeEditar)
        }
        binding.btnMostrar60.setOnClickListener {
            it.findNavController().navigate(R.id.hometoview60)
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
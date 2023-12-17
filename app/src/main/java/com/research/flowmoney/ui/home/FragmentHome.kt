package com.research.flowmoney.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.research.flowmoney.R
import com.research.flowmoney.databinding.FragmentHomeBinding

class FragmentHome : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        menuView()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
    }


    private fun menuView() {
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.fragmentHome -> {
                    true
                }

                R.id.addData -> {
                    findNavController().navigate(FragmentHomeDirections.actionFragmentHomeToFragmentInputData())
                    true
                }


                else -> false
            }
        }
    }

    fun updateBottomNavigationState(destinationId: Int) {
        val menu = binding.bottomNav.menu
        for (i in 0 until menu.size()) {
            val menuItem = menu.getItem(i)
            menuItem.isChecked = menuItem.itemId == destinationId
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
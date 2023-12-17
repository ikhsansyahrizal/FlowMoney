package com.research.flowmoney.ui.inputData

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.research.flowmoney.R
import com.research.flowmoney.core.model.Data
import com.research.flowmoney.databinding.FragmentInputDataBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext


class FragmentInputData : Fragment() {

    private val personCollectionRef = Firebase.firestore.collection("persons")

    private var _binding: FragmentInputDataBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentInputDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSubmit.setOnClickListener {
            val title = binding.edtTitle.text.toString()
            val amount = binding.edtAmount.text.toString()
            val data = Data(title, amount.toInt())
            saveData(data)
        }

        requireActivity().onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().popBackStack(R.id.fragmentHome, false)
                }
            })
    }

    private fun saveData(data: Data) = CoroutineScope(Dispatchers.IO).launch {
        try {
            personCollectionRef.add(data).await()
            withContext(Dispatchers.Main) {
                requireActivity().runOnUiThread {
                    Toast.makeText(requireActivity(), "Success add data", Toast.LENGTH_SHORT).show()
                }
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                requireActivity().runOnUiThread {
                    Toast.makeText(requireActivity(), e.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
package com.heinhtetoo.getgo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.heinhtetoo.getgo.R
import com.heinhtetoo.getgo.base.BaseFragment
import com.heinhtetoo.getgo.databinding.FragmentRentACarBinding

class RentACarFragment : BaseFragment() {

    companion object {
        private val TAG = RentACarFragment::class.java.simpleName
    }

    private var _binding: FragmentRentACarBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRentACarBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initData() {

    }

    private fun initView() {
        drawFullscreen()

        binding.layoutRentACar.layoutRentInfo.tvGo.setOnClickListener { goToSearchResultsFragment() }
    }

    private fun goToSearchResultsFragment() {
        if (findNavController().currentDestination?.id == R.id.rentACarFragment) {
            findNavController().navigate(R.id.action_rentACarFragment_to_searchResultsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.heinhtetoo.getgo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.heinhtetoo.getgo.*
import com.heinhtetoo.getgo.adapter.CarDetailsAdapter
import com.heinhtetoo.getgo.adapter.PagerIndicatorAdapter
import com.heinhtetoo.getgo.base.BaseFragment
import com.heinhtetoo.getgo.databinding.FragmentBookingDetailsBinding
import com.heinhtetoo.getgo.extensions.attachSnapHelperWithListener
import com.heinhtetoo.getgo.utils.DataSet
import com.heinhtetoo.getgo.utils.OnSnapPositionChangeListener

class BookingDetailsFragment : BaseFragment() {

    companion object {
        private val TAG = BookingDetailsFragment::class.java.simpleName
    }

    private var _binding: FragmentBookingDetailsBinding? = null
    private val binding get() = _binding!!

    private lateinit var carDetailsAdapter: CarDetailsAdapter
    private lateinit var pagerIndicatorAdapter: PagerIndicatorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookingDetailsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initData() {

    }

    private fun initView() {
        setupStatusBar(R.color.white)

        setupAdapter()

        binding.btnBack.setOnClickListener { activity?.onBackPressed() }

        binding.layoutBookingPickUp.photoOne.ivThumbnail.isVisible = true
        binding.layoutBookingPickUp.photoTwo.ivThumbnail.isVisible = true
        binding.layoutBookingPickUp.photoThree.ivThumbnail.isVisible = true
    }

    private fun setupAdapter() {
        carDetailsAdapter = CarDetailsAdapter()
        binding.layoutBookingInfo.rvCarDetails.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = this@BookingDetailsFragment.carDetailsAdapter
            attachSnapHelperWithListener(snapHelper = PagerSnapHelper(),
                onSnapPositionChangeListener = object : OnSnapPositionChangeListener {
                    override fun onSnapPositionChange(position: Int) {
                        pagerIndicatorAdapter.indicateAt(position)
                    }
                })
        }

        pagerIndicatorAdapter = PagerIndicatorAdapter(requireContext())

        binding.layoutBookingInfo.rvIndicator.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = pagerIndicatorAdapter
        }

        carDetailsAdapter.setItems(DataSet.carDetails)
        pagerIndicatorAdapter.setData(carDetailsAdapter.itemCount)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
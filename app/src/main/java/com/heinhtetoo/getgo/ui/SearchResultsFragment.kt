package com.heinhtetoo.getgo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinhtetoo.getgo.adapter.CarFoundAdapter
import com.heinhtetoo.getgo.R
import com.heinhtetoo.getgo.base.BaseFragment
import com.heinhtetoo.getgo.databinding.FragmentSearchResultsBinding
import com.heinhtetoo.getgo.utils.DataSet

class SearchResultsFragment : BaseFragment(), CarFoundAdapter.CarFoundItemListener {

    companion object {
        private val TAG = SearchResultsFragment::class.java.simpleName
    }

    private var _binding: FragmentSearchResultsBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: CarFoundAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchResultsBinding.inflate(inflater, container, false)

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

        binding.layoutRentInfo.tvGo.isVisible = false

        binding.btnBack.setOnClickListener { activity?.onBackPressed() }
    }

    private fun setupAdapter() {
        adapter = CarFoundAdapter(this)

        val dividerItemDecoration =
            DividerItemDecoration(context, LinearLayoutManager(context).orientation)
        dividerItemDecoration.setDrawable(
            ContextCompat.getDrawable(requireContext(), R.drawable.divider_horizontal)!!
        )

        binding.rvCarFound.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = this@SearchResultsFragment.adapter
            addItemDecoration(dividerItemDecoration)
        }

        adapter.setItems(DataSet.searchResults)
    }

    private fun goToBookingDetailsFragment() {
        if (findNavController().currentDestination?.id == R.id.searchResultsFragment) {
            findNavController().navigate(R.id.action_searchResultsFragment_to_bookingDetailsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(id: Int) {
        goToBookingDetailsFragment()
    }
}
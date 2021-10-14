package com.heinhtetoo.getgo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.heinhtetoo.getgo.R
import com.heinhtetoo.getgo.base.BaseFragment
import com.heinhtetoo.getgo.databinding.FragmentEmptyBinding

class EmptyFragment : BaseFragment() {

    companion object {
        private val TAG = EmptyFragment::class.java.simpleName
    }

    private var _binding: FragmentEmptyBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmptyBinding.inflate(inflater, container, false)

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
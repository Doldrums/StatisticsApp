package com.example.final_project.Fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.final_project.MainActivity

import com.example.final_project.R
import kotlinx.android.synthetic.main.statfragment_layout.*


class StatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.statfragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_exit_stat.setOnClickListener {
            val ma = this@StatFragment.activity as MainActivity
            ma.changeFragment(3)
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            StatFragment().apply {
            }
    }
}

package com.example.final_project.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.final_project.MainActivity
import com.example.final_project.MainActivity.Companion.BEGIN_FRAGMENT
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

        Log.d("FRAG","Fragment StatFragment started")

        //тут какой-то баг
        btn_exit_stat.setOnClickListener {
            Log.e("bag_tag", "fghj")
            val mainActivity = this@StatFragment.activity as MainActivity
            mainActivity.changeFragment(BEGIN_FRAGMENT)
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            StatFragment().apply {
            }
    }
}

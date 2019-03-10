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


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class StatFragment : Fragment() {

    private var name: String? = null
    private var id: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_PARAM1)
            id = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.statfragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("FRAG","Fragment StatFragment started")
        btn_exitStat.setOnClickListener {
            Log.e("bag_tag", "fghj")
            val mainActivity = this@StatFragment.activity as MainActivity
            mainActivity.changeFragment(BEGIN_FRAGMENT, "null", "null")
        }
        txt_playerName.text = name

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StatFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

package com.example.final_project.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.final_project.MainActivity
import com.example.final_project.R
import kotlinx.android.synthetic.main.beginfragment_layout.*




class BeginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.beginfragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_find.setOnClickListener {
            //Закрываем фрагмент и переходим к ListPlayersFragment
            val ma = this@BeginFragment.activity as MainActivity
            ma.changeFragment(1)

        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            BeginFragment().apply {
            }
    }
}
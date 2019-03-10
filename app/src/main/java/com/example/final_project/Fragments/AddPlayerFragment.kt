package com.example.final_project.Fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.final_project.API.APIFunctions
import com.example.final_project.MainActivity
import com.example.final_project.R
import kotlinx.android.synthetic.main.beginfragment_layout.*


class AddPlayerFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.beginfragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("FRAG", "Fragment AddPlayerFragment started")
        btn_find.setOnClickListener {

            //получаем имя игрока и ищем через API
            val name = input_login.getText().toString()
            val api = APIFunctions(name)

            //Закрываем фрагмент и переходим к ListPlayersFragment
            val ma = this@AddPlayerFragment.activity as MainActivity
            ma.changeFragment(3, "типа Имя", "null")
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AddPlayerFragment().apply {
            }
    }
}

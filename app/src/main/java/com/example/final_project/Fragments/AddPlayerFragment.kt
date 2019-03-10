package com.example.final_project.Fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.final_project.MainActivity
import com.example.final_project.R
import com.google.android.material.snackbar.Snackbar
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
        val playerName = input_login.text.toString()
        btn_find.setOnClickListener {
            if (playerName==""){
                Snackbar.make(it,"Введите что-нибудь",Snackbar.LENGTH_LONG).show()
            }else{
                //тут надо наверное провернуть какие-то действия с апихой дабы проверить адекватно ли имя игрока
                val ma = this@AddPlayerFragment.activity as MainActivity
                ma.changeFragment(3, playerName, "null")
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AddPlayerFragment().apply {
            }
    }
}

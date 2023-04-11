package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.databinding.FragmentSecBlankBinding
import com.example.myapplication.network.Movie
import com.example.myapplication.network.RetrofitClient

class SecBlankFragment : Fragment(R.layout.fragment_sec_blank) {

    lateinit var fragmentSecBlankBinding: FragmentSecBlankBinding
    val customAdapter =CustomAdapter(ArrayList())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSecBlankBinding = FragmentSecBlankBinding.inflate(layoutInflater)
        return fragmentSecBlankBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // prepare data
/*        val data = ArrayList<Car>()
        for (i in 1..10) {
            data += Car("R.id.car", "123", "hundau")
        }*/
        RetrofitClient.getMovies("Lucifer", 1, "3e353d90") { movieArrayList: ArrayList<Movie> ->
            customAdapter.updateList(movieArrayList)
        }

        fragmentSecBlankBinding.recyclerView.apply {
            layoutManager = GridLayoutManager(activity, 2, GridLayoutManager.VERTICAL, false)
            adapter = customAdapter
        }
    }
   //main commit

}
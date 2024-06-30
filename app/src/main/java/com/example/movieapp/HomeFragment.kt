package com.example.movieapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var parentModelClassArrayList: ArrayList<ParentModelClass>
    private lateinit var childModelClassArrayList: ArrayList<ChildModelClass>
    private lateinit var favoriteList: ArrayList<ChildModelClass>
    private lateinit var recentlyWatchedList: ArrayList<ChildModelClass>
    private lateinit var latestList: ArrayList<ChildModelClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.parentRV)
        childModelClassArrayList = ArrayList()
        favoriteList = ArrayList()
        recentlyWatchedList = ArrayList()
        latestList = ArrayList()
        parentModelClassArrayList = ArrayList()

        for (i in 0 until 15) {
            latestList.add(ChildModelClass(R.drawable.fromafar))
        }
        parentModelClassArrayList.add(ParentModelClass("Latest Movies", latestList))

        for (i in 0 until 15) {
            favoriteList.add(ChildModelClass(R.drawable.fromafar))
        }
        parentModelClassArrayList.add(ParentModelClass("Favorite Movies", favoriteList))

        for (i in 0 until 15) {
            recentlyWatchedList.add(ChildModelClass(R.drawable.fromafar))
        }
        parentModelClassArrayList.add(ParentModelClass("Recently Watched Movies", favoriteList))

        childModelClassArrayList.clear()
        for (i in 0 until 10) {
            childModelClassArrayList.add(ChildModelClass(R.drawable.fromafar))
        }

        parentModelClassArrayList.add(ParentModelClass("Recently", childModelClassArrayList))
        parentModelClassArrayList.add(ParentModelClass("Recently", childModelClassArrayList))
        parentModelClassArrayList.add(ParentModelClass("Great", childModelClassArrayList))
        parentModelClassArrayList.add(ParentModelClass("Fine", childModelClassArrayList))
        parentModelClassArrayList.add(ParentModelClass("Recently", childModelClassArrayList))

        val parentAdapter = ParentAdapter(parentModelClassArrayList, requireActivity())
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = parentAdapter
        parentAdapter.notifyDataSetChanged()

        return view
    }
}

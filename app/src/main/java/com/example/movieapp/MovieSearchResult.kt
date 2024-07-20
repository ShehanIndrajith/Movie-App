package com.example.movieapp

import CustomAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment

class MovieSearchResult : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_search_result, container, false)

        val listView: ListView = view.findViewById(R.id.movieresults)

        val items = listOf(
            Item(R.drawable.fromafar, "Movie Name 1", "Category 1", "Release Date 1"),
            Item(R.drawable.fromafar, "Movie Name 2", "Category 2", "Release Date 2")
            // Add more items as needed
        )

        val adapter = CustomAdapter(requireContext(), items)
        listView.adapter = adapter

        return view
    }
}

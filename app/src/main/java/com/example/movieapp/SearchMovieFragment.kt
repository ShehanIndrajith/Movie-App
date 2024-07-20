package com.example.movieapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment

class SearchMovieFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.movie_search, container, false)

        val searchEditText: EditText = view.findViewById(R.id.search_edit_text)

        // Set a focus change listener
        searchEditText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                loadMovieSearchResultFragment()
            }
        }

        // Optionally, set an on-click listener for better UX
        searchEditText.setOnClickListener {
            loadMovieSearchResultFragment()
        }

        return view
    }

    private fun loadMovieSearchResultFragment() {

        view?.findViewById<View>(R.id.grid_layout)?.visibility = View.GONE

        val fragmentTransaction = parentFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.searchresult, MovieSearchResult())
        fragmentTransaction.addToBackStack(null) // Optional: to add the transaction to the back stack
        fragmentTransaction.commit()
    }
}

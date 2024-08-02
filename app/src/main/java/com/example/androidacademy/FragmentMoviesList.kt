package com.example.androidacademy

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentMoviesList : Fragment() {
    private var testText : TextView? = null
    private var fragmentClickListener : ClickListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        testText = view.findViewById<TextView>(R.id.just_test).apply {
            setOnClickListener{
                fragmentClickListener?.moveToNextFragment()
            }
        }
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ClickListener)
            fragmentClickListener = context
    }

    override fun onDetach() {
        super.onDetach()
        fragmentClickListener = null
    }

    companion object {
        fun newInstance(academy : String) : FragmentMoviesList {
            val args = Bundle()
            args.putString("android", academy)
            val fragment = FragmentMoviesList()
            fragment.arguments = args
            return fragment
        }
    }

    interface ClickListener {
        fun moveToNextFragment()
    }
}
package com.crupp52.nachos.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.crupp52.nachos.R
import com.crupp52.nachos.data.model.Movie
import com.crupp52.nachos.ui.viewmodel.MoviesViewModel
import com.crupp52.nachos.utils.InjectorUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectorUtils.provideMoviesViewModelFatory()
        val viewModel = ViewModelProviders.of(this, factory).get(MoviesViewModel::class.java)

        viewModel.add(Movie("ASD"))

        viewModel.getAll().observe(this, Observer { movies ->
            val stringBuilder = StringBuilder()
            movies.forEach { movie -> stringBuilder.append("$movie\n\n") }
            textView.text = stringBuilder.toString()
        })
    }
}

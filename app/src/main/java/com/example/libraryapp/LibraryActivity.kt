package com.example.libraryapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.libraryapp.app.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LibraryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)
    }

}
package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listview.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity() {
    private lateinit var b:ActivityFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityFormBinding.inflate(layoutInflater)
        setContentView(b.root)
        

    }
}
package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        var opSeleccionada = arrayOf("")
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        b.button.setOnClickListener {
            msj(this, opSeleccionada[0])
        }
        val valores = arrayOf("C++", "Python", "JavaScript", "Kotlin", "Java", ".NET",
        "Perl", "PHP", "Haskell", "Rust", "MySQL", "Velazquez", "VisualBasic",
        "Cobol", "Go", "Pascal", "TypeScript", "Lisp", "Swift")
//        val myAdaptador2 = ArrayAdapter.createFromResource(this,
//            R.array.Languages, android.R.layout.)

        ClassSpinner(this,b.spinner2, opSeleccionada, R.array.Languages)
        ClassSpinner(this,b.spinner4, opSeleccionada, valores)

        ListViewClass(this,b.ListView1, valores)
        ListViewClass(this,b.ListView2, R.array.Languages)
    }

}
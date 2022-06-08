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
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        val valores = arrayOf("C++", "Python", "JavaScript", "Kotlin", "Java", ".NET")
        val myAdatador = ArrayAdapter(this,
        android.R.layout.simple_list_item_1, valores)
        b.listViewTest.adapter = myAdatador
        //b.listViewTest.choiceMode = ListView.CHOICE_MODE_SINGLE
        b.listViewTest.setOnItemClickListener { parent:AdapterView<*>, view: View, position:Int,
                                                id: Long ->
            val elemento = myAdatador.getItem(position) as String
            Toast.makeText(this, elemento, Toast.LENGTH_LONG).show()
        }

        b.listViewTest.setOnItemLongClickListener { parent:AdapterView<*>, view: View, pos:Int,
                                                id: Long ->
            Toast.makeText(parent.context, pos, Toast.LENGTH_LONG).show()
            true
        }
    }
}
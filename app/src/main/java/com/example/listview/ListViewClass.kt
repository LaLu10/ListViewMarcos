package com.example.listview

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast


class ListViewClass {
    private lateinit var selectedOption:Array<String>
    private lateinit var myAdaptador: ArrayAdapter<*>
    private var myListView: ListView

    private constructor(listV:ListView){
        myListView = listV
    }

    constructor(listV:ListView, valores: Array<String>):this(listV){
        myAdaptador = ArrayAdapter(listV.context,
            android.R.layout.simple_list_item_activated_1, valores)
        setClick()
    }

    constructor(listV:ListView, valores: Int):this(listV){
        myAdaptador = ArrayAdapter.createFromResource(listV.context, valores,
            android.R.layout.simple_list_item_activated_1)
        setClick()
    }

    fun setClick(){
        myListView.adapter = myAdaptador
        myListView.choiceMode = ListView.CHOICE_MODE_SINGLE
        //myListView.choiceMode = ListView.CHOICE_MODE_MULTIPLE
        myListView.setOnItemClickListener { parent: AdapterView<*>, view: View, position:Int,
                                       id: Long ->
            selectedOption[0] = myAdaptador.getItem(position) as String
        }

        myListView.setOnItemLongClickListener { parent: AdapterView<*>, view: View, pos: Int,
                                           id: Long ->
            Toast.makeText(parent.context, pos.toString(), Toast.LENGTH_LONG).show()
            true
        }
    }
}
package com.example.listview

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast


class ListViewClass {
    private lateinit var myListView: ListView
    private lateinit var selectedOption:Array<String>
    private var myAdaptador: ArrayAdapter<*>

    constructor(myContext:Context, listV:ListView, valores: Array<String>){
        myListView = listV
        myAdaptador = ArrayAdapter(myContext,
            android.R.layout.simple_list_item_activated_1, valores)
        setClick()
    }

    constructor(myContext:Context, listV:ListView, valores: Int){
        myListView = listV
        myAdaptador = ArrayAdapter.createFromResource(myContext, valores,
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
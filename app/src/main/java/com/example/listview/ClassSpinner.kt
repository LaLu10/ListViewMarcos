package com.example.listview

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

class ClassSpinner {
    private lateinit var spinner:Spinner
    private lateinit var selectedOption:Array<String>
    private lateinit var adaptador:ArrayAdapter<*>

    constructor(mySpinner: Spinner, opSelect:Array<String>, data: Int){
        spinner = mySpinner
        selectedOption = opSelect
        adaptador = ArrayAdapter.createFromResource(
            mySpinner.context, data, android.R.layout.simple_spinner_item )
        setClick()
    }

    constructor(mySpinner: Spinner, opSelect:Array<String>, data: Array<String>){
        spinner = mySpinner
        selectedOption = opSelect
        adaptador = ArrayAdapter(mySpinner.context, android.R.layout.simple_spinner_item, data )
        setClick()
    }

    fun setClick() {
        spinner.adapter = adaptador
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedOption[0] = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                selectedOption[0] = "No ha habido selección"
            }
        }
    }
}
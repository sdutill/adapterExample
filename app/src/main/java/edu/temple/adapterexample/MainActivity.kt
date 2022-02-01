package edu.temple.adapterexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val listView = findViewById<ListView>(R.id.listView)

        val colors = arrayOf("Red","Green","Blue","Yellow","Gold")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, colors)
        
        spinner.adapter = adapter
        listView.adapter = adapter

        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                // toast is a temporary message that displays and disappears

                val toastMessage = p0!!.getItemAtPosition(p2) as String

                Toast
                    .makeText(this@MainActivity, toastMessage, Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        spinner.onItemSelectedListener = eventListener

        listView.onItemClickListener = AdapterView.OnItemClickListener( )
    }
}
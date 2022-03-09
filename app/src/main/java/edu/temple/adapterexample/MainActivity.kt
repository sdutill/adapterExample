package edu.temple.adapterviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import edu.temple.adapterexample.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val listView = findViewById<ListView>(R.id.listView)

        val colors = arrayOf("Red", "Green", "Yellow", "Blue", "Gray")
/*
        val adapter = ArrayAdapter(this
            , android.R.layout.simple_spinner_dropdown_item
            , colors)

 */

        val adapter = ColorAdapter(this, colors)

        spinner.adapter = adapter
        listView.adapter = adapter


        val eventListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                val messageString = p0!!.getItemAtPosition(p2).toString()

                Toast
                    .makeText(this@MainActivity, messageString, Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }

        val onItemClickListener = object: AdapterView.OnItemClickListener {
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val messageString = p0!!.getItemAtPosition(p2).toString()

                Toast
                    .makeText(this@MainActivity, messageString, Toast.LENGTH_SHORT)
                    .show()
            }

        }

        spinner.onItemSelectedListener = eventListener

        listView.onItemClickListener = onItemClickListener

    }
}
package com.android.jyotirani.listviewpracise

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.row_main.view.*
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.mainListView)

        listView.adapter = MyCustomAdapter(this)
    }

    private class MyCustomAdapter(context: Context): BaseAdapter() {

        private val mContext: Context

        private val names = arrayListOf<String>(
                "Donald Trump", "Steve Jobs", "Tim Cook"
        )

        init {
            mContext = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.row_main, parent, false)

            val positionTextView = rowMain.findViewById<TextView>(R.id.position_textview)
            positionTextView.text = "Row Number: $position"

            val nameTextView = rowMain.findViewById<TextView>(R.id.name_textView)
            nameTextView.text = names.get(position)

            return rowMain

//            val textView = TextView(mContext)
//            textView.setText("Here is my row for my listview.")
//            return textView
        }

        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }

        override fun getCount(): Int {
            return names.size
        }

        override fun getItemId(position: Int): Long {
        return position.toLong()
        }
    }


}

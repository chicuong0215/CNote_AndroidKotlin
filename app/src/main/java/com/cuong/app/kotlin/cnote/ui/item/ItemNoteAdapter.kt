package com.cuong.app.kotlin.cnote.ui.item

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.TextView
import com.cuong.app.kotlin.cnote.R
import com.cuong.app.kotlin.cnote.data.db.model.Note
import com.cuong.app.kotlin.cnote.ui.main.MainActivity

class ItemNoteAdapter(private val context: MainActivity, private val notes: ArrayList<Note>) :
    BaseAdapter() {
    override fun getCount(): Int {
        return notes.size;
    }

    override fun getItem(p0: Int): Any {
        return 0
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        //create views
        val inflater = LayoutInflater.from(context)
        val v = inflater.inflate(R.layout.item_note, null)
        val tvTile = v.findViewById<TextView>(R.id.tvTitle)
        val tvContent = v.findViewById<TextView>(R.id.tvContent)
        val ibtnDelete = v.findViewById<ImageButton>(R.id.ibtnDelete)
        ibtnDelete.setOnClickListener(View.OnClickListener {
            notes.removeAt(p0)
            context.updateListNote()
        })
        //set value for views
        val note = notes[p0]
        tvTile.text = note.title
        tvContent.text = note.content
        return v
    }
}
package com.cuong.app.kotlin.cnote.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.GridView
import com.cuong.app.kotlin.cnote.R
import com.cuong.app.kotlin.cnote.data.db.model.Note
import com.cuong.app.kotlin.cnote.ui.dialog.AddNoteDialog
import com.cuong.app.kotlin.cnote.ui.item.ItemNoteAdapter
import com.cuong.app.kotlin.cnote.utils.ScreenUtils
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), MainView {
    private val screenUtils = ScreenUtils()

    private lateinit var gvNote: GridView
    private lateinit var fabAdd: FloatingActionButton

    private val notes = ArrayList<Note>()
    private lateinit var itemNoteAdapter: ItemNoteAdapter

    private val mainPresenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        screenUtils.setFullScreen(window)
        init()
    }

    private fun init() {
        gvNote = findViewById(R.id.gvNote)
        fabAdd = findViewById(R.id.fabAdd)

        for (i in 1..10) {
            notes.add(Note(0, "Tiêu đề $i", "Nội dung $i\nNội dung $i"))
        }

        itemNoteAdapter = ItemNoteAdapter(this, notes)

        gvNote.adapter = itemNoteAdapter;

        fabAdd.setOnClickListener(View.OnClickListener {
            AddNoteDialog(this).show()
        })
    }

    override fun updateListNote() {
        itemNoteAdapter.notifyDataSetChanged()
    }

    fun addNote(note: Note) {
        mainPresenter.addNote(notes, note)
    }
}
package com.cuong.app.kotlin.cnote.ui.main

import com.cuong.app.kotlin.cnote.data.db.model.Note

class MainPresenter(mainView: MainView) {
    var mainView = mainView
    fun addNote(notes: ArrayList<Note>, note: Note) {
        notes.add(note)
        mainView.updateListNote()
    }
}
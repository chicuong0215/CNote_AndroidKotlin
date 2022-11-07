package com.cuong.app.kotlin.cnote.ui.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.cuong.app.kotlin.cnote.R
import com.cuong.app.kotlin.cnote.data.db.model.Note
import com.cuong.app.kotlin.cnote.ui.main.MainActivity

class AddNoteDialog(private val context: MainActivity) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window?.setBackgroundDrawableResource(android.R.color.transparent)
        setContentView(R.layout.dialog_add_note);

        val edtTitle = findViewById<EditText>(R.id.edtTitle);
        val edtContent = findViewById<EditText>(R.id.edtContent);
        val btnAdd = findViewById<Button>(R.id.btnAdd);

        btnAdd.setOnClickListener(View.OnClickListener {
            context.addNote(Note(0, edtTitle.text.toString(), edtContent.text.toString()))
            context.updateListNote()
            this.cancel()
        })
    }
}
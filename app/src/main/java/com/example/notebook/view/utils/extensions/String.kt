package com.example.notebook.view.utils.extensions

import android.text.Editable


// TODO: delete all class
fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)
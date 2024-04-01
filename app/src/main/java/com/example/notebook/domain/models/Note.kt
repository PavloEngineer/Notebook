package com.example.notebook.domain.models

import android.os.Parcelable
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Note (
     val title: String,
     val text: String,
 ) : Parcelable {
    @IgnoredOnParcel
    var id: Int = 0
 }
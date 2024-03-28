package com.example.notebook.data.note.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "note")
data class Note(
    val title: String,
    val text: String
) : Parcelable {

    @PrimaryKey(autoGenerate = true)
    @IgnoredOnParcel
    var id: Int = 0
}
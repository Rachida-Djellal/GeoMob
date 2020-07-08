package com.example.geomob.DataClasses


import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.geomob.DataClasses.Personalite

@Entity(tableName = "PersonalitePhoto",
    foreignKeys = [ForeignKey(
        entity = Personalite::class,
        parentColumns = arrayOf("idPersonalite"),
        childColumns = arrayOf("idPersonalite"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class PersonalitePhoto (@PrimaryKey(autoGenerate = true) val idPersonalitePhoto: Long?,
                             val resId : Int,
                             val idPersonalite : Long) {}
package com.example.geomob.DataClasses


import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Evenement",
    foreignKeys = [ForeignKey(
        entity = Pays::class,
        parentColumns = arrayOf("codePays"),
        childColumns = arrayOf("codePays"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class Evenement (@PrimaryKey(autoGenerate = true) val idEvenement: Long?,
                        val date : String,
                        var description : String,
                        val codePays : String) {}
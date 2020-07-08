package com.example.geomob.DataClasses

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.geomob.DataClasses.Pays

@Entity(tableName = "Personlaite",
    foreignKeys = [ForeignKey(
    entity = Pays::class,
    parentColumns = arrayOf("codePays"),
    childColumns = arrayOf("codePays"),
    onDelete = ForeignKey.CASCADE
)]
)
data class Personalite (@PrimaryKey(autoGenerate = true) val idPersonalite: Long?,
                        val nomPersonalite : String,
                        var resId : Int,
                        val codePays : String) {}

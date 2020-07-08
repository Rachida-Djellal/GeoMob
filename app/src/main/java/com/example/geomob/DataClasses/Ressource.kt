package com.example.geomob.DataClasses



import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.geomob.DataClasses.Pays

@Entity(tableName = "Ressource",
    foreignKeys = [ForeignKey(entity = Pays::class,
        parentColumns = arrayOf("codePays"),
        childColumns = arrayOf("codePays"),
        onDelete = ForeignKey.CASCADE)]
)
data class Ressource (@PrimaryKey(autoGenerate = true) val idRessource: Long?,
                      val nomRessource : String,
                      var description : String,
                      val codePays : String) {

}


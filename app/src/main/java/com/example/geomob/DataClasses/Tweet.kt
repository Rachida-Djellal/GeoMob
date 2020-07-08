package com.example.geomob.DataClasses


import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.geomob.DataClasses.Pays

@Entity(tableName = "Tweet",
    foreignKeys = [ForeignKey(
        entity = Pays::class,
        parentColumns = arrayOf("codePays"),
        childColumns = arrayOf("codePays"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class Tweet (@PrimaryKey(autoGenerate = true) val idTweet: Long?,
                        val userImg : String,
                        val userName : String,
                        val screenName : String,
                        val img : String,
                        val contenu : String,
                        val codePays : String) {}
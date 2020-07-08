package com.example.geomob.DataClasses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Pays")

data class Pays(@PrimaryKey val codePays: String,
                val nomPays: String,
                val capital: String,
                var descriptionPays: String,
                var surface: Long,
                var population: Long,
                var hymne: Int,
                var seen : Boolean){}
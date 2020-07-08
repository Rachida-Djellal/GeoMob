package com.example.geomob.Database

import androidx.room.*
import com.example.geomob.DataClasses.*

@Dao
interface PaysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPays(pays: Pays)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRessource(ressource: Ressource)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addEvenement(evenement: Evenement)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPaysPhoto(paysPhoto: PaysPhoto)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPaysVideo(paysVideo: PaysVideo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPersonalite(personalite: Personalite)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPersonalitePhoto(personalitePhoto: PersonalitePhoto)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTweet(tweet: Tweet)

    @Update
    fun modifyPays(pays: Pays)

    @Update
    fun modifyRessource(ressource: Ressource)

    @Update
    fun modifyEvenement(evenement: Evenement)

    @Update
    fun modifyPaysPhoto(paysPhoto: PaysPhoto)

    @Update
    fun modifyPaysVideo(paysVideo: PaysVideo)

    @Update
    fun modifyPersonalite(personalite: Personalite)

    @Update
    fun modifyPersonalitePhoto(personalitePhoto: PersonalitePhoto)

    @Update
    fun modifyTweet(tweet: Tweet)

    @Delete
    fun deletePays(pays: Pays)

    @Delete
    fun deleteRessource(ressource: Ressource)

    @Delete
    fun deleteEvenement(evenement: Evenement)

    @Delete
    fun deletePaysPhoto(paysPhoto: PaysPhoto)

    @Delete
    fun deletePaysVideo(paysVideo: PaysVideo)

    @Delete
    fun deletePersonalite(personalite: Personalite)

    @Delete
    fun deletePersonalitePhoto(personalitePhoto: PersonalitePhoto)

    @Delete
    fun deleteTweet(tweet: Tweet)

    @Query("Select * from Pays Order By seen DESC, nomPays")
    fun loadAllPays(): List<Pays>

    @Query("Select * from Pays WHERE seen = 0")
    fun loadUnseenPays(): List<Pays>

    @Query("Select * from Pays Where codePays = :countryCode")
    fun findPaysByCountryCode(countryCode : String): List<Pays>

    @Query("Select * from Ressource")
    fun loadAllRessources(): List<Ressource>

    @Query("Select * from Ressource where codePays = :countryCode")
    fun loadAllRessourcesByCountryCode(countryCode : String): List<Ressource>

    @Query("Select * from Personlaite where codePays = :countryCode")
    fun loadAllPersonalitesByPaysCountryCode(countryCode : String): List<Personalite>

    @Query("Select * from Tweet where codePays = :countryCode")
    fun loadAllTweetsByPaysCountryCode(countryCode : String): List<Tweet>

    @Query("Select * from PaysPhoto where codePays = :countryCode")
    fun loadAllPaysPhotoByPaysCountryCode(countryCode : String): List<PaysPhoto>

    @Query("Select * from PaysVideo where codePays = :countryCode")
    fun loadAllPaysVideoByPaysCountryCode(countryCode : String): List<PaysVideo>

    @Query("Select * from Evenement where codePays = :countryCode")
    fun loadAllEvenementByPaysCountryCode(countryCode : String): List<Evenement>

    @Query("Select * from PersonalitePhoto where idPersonalite = :personaliteId")
    fun loadAllPersonalitesPhotoByPaysId(personaliteId : Long): List<PersonalitePhoto>

    @Query("Update Pays SET seen = 1 WHERE codePays = :countryCode")
    fun markAsSeen(countryCode: String)
}
package com.example.examparcial.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ScoreDao {
    @Insert
    suspend fun insertScore(score: ScoreEntity)

    @Query("SELECT * FROM scores ORDER BY id DESC")
    suspend fun getAllScores(): List<ScoreEntity>

    @Query("SELECT MAX(puntos) FROM scores")
    suspend fun getMaxScore(): Int?
}
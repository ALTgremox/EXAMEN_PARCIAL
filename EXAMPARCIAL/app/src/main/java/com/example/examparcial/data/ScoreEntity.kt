package com.example.examparcial.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scores")
data class ScoreEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val puntos: Int,
    val fecha: Long = System.currentTimeMillis()
)
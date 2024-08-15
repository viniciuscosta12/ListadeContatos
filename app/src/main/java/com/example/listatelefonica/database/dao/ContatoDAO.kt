package com.example.listatelefonica.database.dao

import androidx.room.*
import com.example.listatelefonica.model.Contato


@Dao
interface ContatoDAO {

    @Insert
    fun insert(contato: Contato): Long

    @Update
    fun update(contato: Contato): Int

    @Delete
    fun delete(contato: Contato): Int

    @Query("SELECT * FROM Contato")
    fun selectAll(): List<Contato>

    @Query("SELECT * FROM Contato WHERE id=:id")
    fun select(id: Int): Contato
}
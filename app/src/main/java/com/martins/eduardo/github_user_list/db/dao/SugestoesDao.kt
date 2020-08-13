package com.martins.eduardo.github_user_list.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.martins.eduardo.github_user_list.models.Sugestao

@Dao
interface SugestoesDao{
    //todo create CRUD

    @Query("SELECT * FROM Sugestao")
    suspend fun getAllSugestoes() : List<Sugestao>

    @Insert(onConflict = REPLACE)
    suspend fun atualizaHistoricoBusca(sugestao: Sugestao)
}
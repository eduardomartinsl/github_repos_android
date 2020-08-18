package com.martins.eduardo.github_user_list.db.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.martins.eduardo.github_user_list.models.Sugestao

@Dao
interface SugestoesDao{
    @Query("SELECT * FROM Sugestao")
    suspend fun getAllSugestoes() : List<Sugestao>

    @Query("Select * from Sugestao where sugestao =:sugestao")
    suspend fun findSugestao(sugestao: String): Sugestao

    @Insert(onConflict = REPLACE)
    suspend fun atualizaHistoricoBusca(sugestao: Sugestao)


    @Delete
    suspend fun deletaSugestao(sugestao: Sugestao)
}
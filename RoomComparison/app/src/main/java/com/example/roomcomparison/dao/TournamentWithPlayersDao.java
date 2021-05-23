package com.example.roomcomparison.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.roomcomparison.entity.TournamentWithPlayers;
import com.example.roomcomparison.entity.relations.manyToMany.TournamentPlayerCrossRefEntity;

import java.util.List;

@Dao
public interface TournamentWithPlayersDao {
    @Insert
    void insertTournamentWithPlayers(TournamentPlayerCrossRefEntity tournamentPlayerCrossRef);

    @Transaction
    @Query("SELECT * FROM Tournament")
    LiveData<List<TournamentWithPlayers>> getTournamentWithPlayers();
}

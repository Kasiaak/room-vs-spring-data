package com.example.roomcomparison.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.roomcomparison.entity.MatchWithPlayers;
import com.example.roomcomparison.entity.relations.manyToMany.MatchPlayerCrossRefEntity;

import java.util.List;

@Dao
public interface MatchWithPlayersDao {
    @Insert
    void insertMatchWithPlayers(MatchPlayerCrossRefEntity playerMatchCrossRefEntity);

    @Transaction
    @Query("SELECT * FROM MatchEntity")
    LiveData<List<MatchWithPlayers>> getMatchWithPlayers();

    @Transaction
    @Query("SELECT * FROM MatchEntity WHERE tournamentUUIDFK = :tournamentUUID AND match_ended = :matchEnded")
    LiveData<List<MatchWithPlayers>> getMatchWithPlayersByTournament(String tournamentUUID, boolean matchEnded);

    @Transaction
    @Query("SELECT * FROM MatchEntity WHERE tournamentUUIDFK = :tournamentUUID")
    LiveData<List<MatchWithPlayers>> getMatchWithPlayersByTournamentOnly(String tournamentUUID);
}

package com.example.roomcomparison.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.roomcomparison.entity.TournamentWithMatches;

import java.util.List;

@Dao
public interface TournamentWithMatchesDao {
    @Transaction
    @Query("SELECT * FROM Tournament WHERE tournamentUUID LIKE :tournamentUUID")
    LiveData<List<TournamentWithMatches>> getMatchesAssignedToTournament(String tournamentUUID);
}

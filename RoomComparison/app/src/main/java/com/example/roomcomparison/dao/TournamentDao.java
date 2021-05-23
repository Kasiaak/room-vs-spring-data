package com.example.roomcomparison.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.roomcomparison.entity.TournamentWithMatches;
import com.example.roomcomparison.entity.tournament.Tournament;

import java.util.List;

@Dao
public interface TournamentDao {
    @Query("SELECT * FROM Tournament")
    LiveData<List<Tournament>> getAllTournaments();

    @Query("SELECT * FROM Tournament WHERE tournament_name LIKE :name")
    Tournament findTournamentByName(String name);

    @Insert
    void insertTournament(Tournament tournament);

    @Query("DELETE FROM Tournament")
    void deleteAllTournaments();

    @Transaction
    @Query("SELECT * FROM Tournament")
    LiveData<List<TournamentWithMatches>> getTournamentsWithMatches();

}
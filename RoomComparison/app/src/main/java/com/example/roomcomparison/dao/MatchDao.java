package com.example.roomcomparison.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.roomcomparison.entity.match.MatchEntity;

import java.util.List;


@Dao
public interface MatchDao {
    @Query("SELECT 1")
    String dummyQuery();

    @Query("SELECT * FROM MatchEntity")
    LiveData<List<MatchEntity>> getAllMatches();

    @Insert
    void insertMatch(MatchEntity match);

    @Query("DELETE FROM MatchEntity")
    void deleteAllMatches();

    @Query("UPDATE MatchEntity SET player_one_points = :playerOnePoints, player_two_points = :playerTwoPoints WHERE matchUUID LIKE :matchUUID")
    void updatePlayersPoints(int playerOnePoints, int playerTwoPoints, String matchUUID);

    @Query("UPDATE MatchEntity SET match_ended = :matchEnded WHERE matchUUID LIKE :matchUUID")
    void updateEndedMatch(String matchUUID, boolean matchEnded);

    @Transaction
    @Query("SELECT * FROM MatchEntity WHERE player_one_id = :playerUUID OR player_two_id = :playerUUID")
    LiveData<List<MatchEntity>> getMatchesForPlayer(String playerUUID);

    @Transaction
    @Query("SELECT * FROM MatchEntity WHERE (player_one_id = :playerUUID OR player_two_id = :playerUUID) AND match_ended = 1")
    LiveData<List<MatchEntity>> getFinishedMatchesForPlayer(String playerUUID);
}

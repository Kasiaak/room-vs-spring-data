package com.example.roomcomparison.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomcomparison.entity.player.Player;

import java.util.List;

@Dao
public interface PlayerDao {
    @Query("SELECT * FROM Player")
    LiveData<List<Player>> getAllPlayers();

    @Query("SELECT * FROM Player WHERE player_name LIKE :playerName")
    Player findPlayerByName(String playerName);

    @Insert
    void insertPlayer(Player player);

    @Query("DELETE FROM Player")
    void deleteAllPlayers();

}

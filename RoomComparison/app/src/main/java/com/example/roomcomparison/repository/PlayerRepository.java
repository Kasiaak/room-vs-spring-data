package com.example.roomcomparison.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.roomcomparison.dao.PlayerDao;
import com.example.roomcomparison.database.RoomComparisonDatabase;
import com.example.roomcomparison.entity.player.Player;

import java.util.List;

public class PlayerRepository {
    private final PlayerDao mPlayerDao;

    public PlayerRepository(Application application) {
        RoomComparisonDatabase db = RoomComparisonDatabase.getDatabase(application);
        mPlayerDao = db.playerTournamentProfileDao();
    }

    public LiveData<List<Player>> getAllPlayers() {
        return mPlayerDao.getAllPlayers();
    }

    public void insertPlayer(Player player) {
        RoomComparisonDatabase.databaseWriteExecutor.execute(() -> {
            mPlayerDao.insertPlayer(player);
        });
    }

    public void deleteAllPlayers() {
        RoomComparisonDatabase.databaseWriteExecutor.execute(() -> {
            mPlayerDao.deleteAllPlayers();
        });
    }
}

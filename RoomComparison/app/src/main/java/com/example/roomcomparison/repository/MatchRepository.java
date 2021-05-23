package com.example.roomcomparison.repository;

import android.app.Application;


import androidx.lifecycle.LiveData;

import com.example.roomcomparison.dao.MatchDao;
import com.example.roomcomparison.database.RoomComparisonDatabase;
import com.example.roomcomparison.entity.match.MatchEntity;

import java.util.List;

public class MatchRepository {
    private final MatchDao mMatchDao;

    public MatchRepository(Application application) {
        RoomComparisonDatabase db = RoomComparisonDatabase.getDatabase(application);
        mMatchDao = db.matchDao();
    }

    public void dummyQuery() {
        RoomComparisonDatabase.databaseWriteExecutor.execute(() -> {
            mMatchDao.dummyQuery();
        });
    }

    public LiveData<List<MatchEntity>> getAllMatches() {
        return mMatchDao.getAllMatches();
    }

    public void insertMatch(MatchEntity match) {
        RoomComparisonDatabase.databaseWriteExecutor.execute(() -> {
            mMatchDao.insertMatch(match);
        });
    }

    public void deleteAllMatches() {
        RoomComparisonDatabase.databaseWriteExecutor.execute(() -> {
            mMatchDao.deleteAllMatches();
        });
    }

    public void updatePlayersPoints(int playerOnePoints, int playerTwoPoints, String matchUUID) {
        RoomComparisonDatabase.databaseWriteExecutor.execute(() ->
                mMatchDao.updatePlayersPoints(playerOnePoints, playerTwoPoints, matchUUID));
    }

    public void updateEndedMatch(String matchUUID, boolean matchEnded) {
        RoomComparisonDatabase.databaseWriteExecutor.execute(() ->
                mMatchDao.updateEndedMatch(matchUUID, matchEnded));
    }

    public LiveData<List<MatchEntity>> getMatchesForPlayer(String playerUUID) {
        return mMatchDao.getMatchesForPlayer(playerUUID);
    }

    public LiveData<List<MatchEntity>> getFinishedMatchesForPlayer(String playerUUID) {
        return mMatchDao.getFinishedMatchesForPlayer(playerUUID);
    }
}

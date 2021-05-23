package com.example.roomcomparison.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.roomcomparison.dao.MatchWithPlayersDao;
import com.example.roomcomparison.database.RoomComparisonDatabase;
import com.example.roomcomparison.entity.MatchWithPlayers;
import com.example.roomcomparison.entity.relations.manyToMany.MatchPlayerCrossRefEntity;

import java.util.List;

public class MatchWithPlayersRepository {
    private final MatchWithPlayersDao mMatchWithPlayersDao;

    public MatchWithPlayersRepository(Application application) {
        RoomComparisonDatabase db = RoomComparisonDatabase.getDatabase(application);
        mMatchWithPlayersDao = db.matchWithPlayersDao();
    }

    public void insertMatchWithPlayers(MatchPlayerCrossRefEntity matchPlayerCrossRefEntity) {
        RoomComparisonDatabase.databaseWriteExecutor.execute(() -> {
            mMatchWithPlayersDao.insertMatchWithPlayers(matchPlayerCrossRefEntity);
        });
    }

    public LiveData<List<MatchWithPlayers>> getMatchWithPlayers() {
        return mMatchWithPlayersDao.getMatchWithPlayers();
    }

    public LiveData<List<MatchWithPlayers>> getMatchWithPlayersByTournament(String tournamentUUID, boolean matchEnded) {
        return mMatchWithPlayersDao.getMatchWithPlayersByTournament(tournamentUUID, matchEnded);
    }

    public LiveData<List<MatchWithPlayers>> getMatchWithPlayersByTournamentOnly(String tournamentUUID) {
        return mMatchWithPlayersDao.getMatchWithPlayersByTournamentOnly(tournamentUUID);
    }
}

package com.example.roomcomparison.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.roomcomparison.dao.TournamentWithPlayersDao;
import com.example.roomcomparison.database.RoomComparisonDatabase;
import com.example.roomcomparison.entity.TournamentWithPlayers;
import com.example.roomcomparison.entity.relations.manyToMany.TournamentPlayerCrossRefEntity;

import java.util.List;

public class TournamentWithPlayersRepository {
    private final TournamentWithPlayersDao mTournamentWithPlayersDao;

    public TournamentWithPlayersRepository(Application application) {
        RoomComparisonDatabase db = RoomComparisonDatabase.getDatabase(application);
        mTournamentWithPlayersDao = db.tournamentWithPlayersDao();
    }

    public void insertTournamentWithPlayers(TournamentPlayerCrossRefEntity tournamentPlayerCrossRefEntity) {
        RoomComparisonDatabase.databaseWriteExecutor.execute(() -> {
            mTournamentWithPlayersDao.insertTournamentWithPlayers(tournamentPlayerCrossRefEntity);
        });
    }

    public LiveData<List<TournamentWithPlayers>> getTournamentWithPlayers() {
        return mTournamentWithPlayersDao.getTournamentWithPlayers();
    }
}

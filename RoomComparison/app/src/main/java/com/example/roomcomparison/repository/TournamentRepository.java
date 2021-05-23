package com.example.roomcomparison.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.roomcomparison.dao.TournamentDao;
import com.example.roomcomparison.database.RoomComparisonDatabase;
import com.example.roomcomparison.entity.tournament.Tournament;

import java.util.List;

public class TournamentRepository {
    private final TournamentDao mTournamentDao;

    public TournamentRepository(Application application) {
        RoomComparisonDatabase db = RoomComparisonDatabase.getDatabase(application);
        mTournamentDao = db.tournamentDao();
    }

    public LiveData<List<Tournament>> getAllTournaments() {
        return mTournamentDao.getAllTournaments();
    }

    public void insertTournament(Tournament tournament) {
        RoomComparisonDatabase.databaseWriteExecutor.execute(() -> {
            mTournamentDao.insertTournament(tournament);
        });
    }

    public void deleteAllTournaments() {
        RoomComparisonDatabase.databaseWriteExecutor.execute(() -> {
            mTournamentDao.deleteAllTournaments();
        });
    }
}

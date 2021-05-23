package com.example.roomcomparison.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.roomcomparison.dao.TournamentWithMatchesDao;
import com.example.roomcomparison.database.RoomComparisonDatabase;
import com.example.roomcomparison.entity.TournamentWithMatches;

import java.util.List;

public class TournamentWithMatchesRepository {
    private final TournamentWithMatchesDao mTournamentWithMatchesDao;

    public TournamentWithMatchesRepository(Application application) {
        RoomComparisonDatabase db = RoomComparisonDatabase.getDatabase(application);
        mTournamentWithMatchesDao = db.tournamentWithMatchesDao();
    }

    public LiveData<List<TournamentWithMatches>> getMatchesAssignedToTournament(String tournamentUUID) {
        return mTournamentWithMatchesDao.getMatchesAssignedToTournament(tournamentUUID);
    }
}

package com.example.roomcomparison.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.roomcomparison.entity.TournamentWithMatches;
import com.example.roomcomparison.entity.tournament.Tournament;
import com.example.roomcomparison.repository.TournamentRepository;

import java.util.List;

public class TournamentViewModel extends AndroidViewModel {
    private final TournamentRepository mTournamentRepository;
    private final LiveData<List<Tournament>> mAllTournaments;
    private List<TournamentWithMatches> mMatchesAssignedToTournament;

    public TournamentViewModel(Application application) {
        super(application);
        mTournamentRepository = new TournamentRepository(application);
        mAllTournaments = mTournamentRepository.getAllTournaments();
    }

    public LiveData<List<Tournament>> getAllTournaments() {
        return mAllTournaments;
    }

    public void insertTournament(Tournament tournament) {
        mTournamentRepository.insertTournament(tournament);
    }

    public void deleteAllTournaments() {
        mTournamentRepository.deleteAllTournaments();
    }
}

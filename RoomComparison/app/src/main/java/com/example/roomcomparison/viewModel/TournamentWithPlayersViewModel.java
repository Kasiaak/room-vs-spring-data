package com.example.roomcomparison.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.roomcomparison.entity.TournamentWithPlayers;
import com.example.roomcomparison.entity.relations.manyToMany.TournamentPlayerCrossRefEntity;
import com.example.roomcomparison.repository.TournamentWithPlayersRepository;

import java.util.List;

public class TournamentWithPlayersViewModel extends AndroidViewModel {

    private final TournamentWithPlayersRepository mTournamentWithPlayersRepository;
    private final LiveData<List<TournamentWithPlayers>> mTournamentWithPlayers;

    public TournamentWithPlayersViewModel(Application application) {
        super(application);
        mTournamentWithPlayersRepository = new TournamentWithPlayersRepository(application);
        mTournamentWithPlayers = mTournamentWithPlayersRepository.getTournamentWithPlayers();
    }

    public LiveData<List<TournamentWithPlayers>> getAllTournamentsWithPlayers() {
        return mTournamentWithPlayers;
    }

    public void insertTournamentWithPlayer(TournamentPlayerCrossRefEntity tournamentPlayerCrossRefEntity) {
        mTournamentWithPlayersRepository.insertTournamentWithPlayers(tournamentPlayerCrossRefEntity);
    }
}

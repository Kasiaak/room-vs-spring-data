package com.example.roomcomparison.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.roomcomparison.entity.MatchWithPlayers;
import com.example.roomcomparison.entity.relations.manyToMany.MatchPlayerCrossRefEntity;
import com.example.roomcomparison.repository.MatchWithPlayersRepository;

import java.util.List;

public class MatchWithPlayersViewModel extends AndroidViewModel {
    private final MatchWithPlayersRepository mMatchWithPlayersRepository;
    private final LiveData<List<MatchWithPlayers>> mMatchWithPlayers;
    private final MutableLiveData<MatchFilter> mMatchFilter = new MutableLiveData<>();
    private final MutableLiveData<String> mTournamentUUID = new MutableLiveData<>();
    private final LiveData<List<MatchWithPlayers>> mMatchWithPlayersByTournament;
    private final LiveData<List<MatchWithPlayers>> mMatchWithPlayersOnlyByTournament;

    public MatchWithPlayersViewModel(Application application) {
        super(application);
        mMatchWithPlayersRepository = new MatchWithPlayersRepository(application);
        mMatchWithPlayers = mMatchWithPlayersRepository.getMatchWithPlayers();
        mMatchWithPlayersByTournament = Transformations.switchMap(mMatchFilter,
                (matchFilter -> mMatchWithPlayersRepository.getMatchWithPlayersByTournament(matchFilter.tournamentUUID, matchFilter.matchEnded)));
        mMatchWithPlayersOnlyByTournament = Transformations.switchMap(mTournamentUUID, (mTournamentUUIDValue ->
                mMatchWithPlayersRepository.getMatchWithPlayersByTournamentOnly(mTournamentUUIDValue)));
    }

    public LiveData<List<MatchWithPlayers>> getAllMatchesWithPlayers() {
        return mMatchWithPlayers;
    }

    public void insertMatchWithPlayer(MatchPlayerCrossRefEntity matchPlayerCrossRefEntity) {
        mMatchWithPlayersRepository.insertMatchWithPlayers(matchPlayerCrossRefEntity);
    }

    public LiveData<List<MatchWithPlayers>> getMatchWithPlayersByTournament(String tournamentUUID, boolean matchEnded) {
        mMatchFilter.setValue(new MatchFilter(tournamentUUID, matchEnded));
        return mMatchWithPlayersByTournament;
    }

    public LiveData<List<MatchWithPlayers>> getMatchWithPlayersByTournamentOnly(String tournamentUUID) {
        this.mTournamentUUID.setValue(tournamentUUID);
        return mMatchWithPlayersOnlyByTournament;
    }

    private static class MatchFilter {
        final String tournamentUUID;
        final boolean matchEnded;

        MatchFilter(String tournamentUUID, boolean matchEnded) {
            this.tournamentUUID = tournamentUUID;
            this.matchEnded = matchEnded;
        }
    }
}

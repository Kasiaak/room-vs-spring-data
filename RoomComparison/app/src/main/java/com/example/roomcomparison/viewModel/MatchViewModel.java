package com.example.roomcomparison.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.roomcomparison.entity.match.MatchEntity;
import com.example.roomcomparison.repository.MatchRepository;

import java.util.List;


public class MatchViewModel extends AndroidViewModel {
    private final MatchRepository mMatchRepository;
    private final LiveData<List<MatchEntity>> mAllMatches;
    private final MutableLiveData<String> mFilteredPlayerUUID = new MutableLiveData<>();
    private final LiveData<List<MatchEntity>> mMatchesWithPlayer;

    public MatchViewModel(Application application) {
        super(application);
        mMatchRepository = new MatchRepository(application);
        mAllMatches = mMatchRepository.getAllMatches();
        mMatchesWithPlayer = Transformations.switchMap(mFilteredPlayerUUID, (mFilteredPlayerUUIDValue -> mMatchRepository.getMatchesForPlayer(mFilteredPlayerUUIDValue)));
    }

    public void dummyQuery() {
        mMatchRepository.dummyQuery();
    }

    public LiveData<List<MatchEntity>> getAllMatches() {
        return mAllMatches;
    }

    public void insertMatch(MatchEntity match) {
        mMatchRepository.insertMatch(match);
    }

    public void deleteAllMatches() {
        mMatchRepository.deleteAllMatches();
    }

    public void updatePlayersPoints(int playerOnePoints, int playerTwoPoints, String matchUUID) {
        mMatchRepository.updatePlayersPoints(playerOnePoints, playerTwoPoints, matchUUID);
    }

    public void updateEndedMatch(String matchUUID, boolean matchEnded) {
        mMatchRepository.updateEndedMatch(matchUUID, matchEnded);
    }

    public LiveData<List<MatchEntity>> getMatchesForPlayer(String playerUUID) {
        mFilteredPlayerUUID.setValue(playerUUID);
        return mMatchesWithPlayer;
    }
}

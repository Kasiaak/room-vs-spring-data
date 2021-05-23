package com.example.roomcomparison.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.roomcomparison.entity.TournamentWithMatches;
import com.example.roomcomparison.repository.TournamentWithMatchesRepository;

import java.util.List;

public class TournamentWithMatchesViewModel extends AndroidViewModel {

    private final TournamentWithMatchesRepository mTournamentWithMatchesRepository;
    private final MutableLiveData<String> mTournamentUUID = new MutableLiveData<>();
    private final LiveData<List<TournamentWithMatches>> mMatchesAssignedToTournament;

    public TournamentWithMatchesViewModel(Application application) {
        super(application);
        mTournamentWithMatchesRepository = new TournamentWithMatchesRepository(application);
        mMatchesAssignedToTournament = Transformations.switchMap(mTournamentUUID, (mTournamentUUIDValue -> mTournamentWithMatchesRepository.getMatchesAssignedToTournament(mTournamentUUIDValue)));
    }

    public LiveData<List<TournamentWithMatches>> getMatchesAssignedToTournament(String tournamentUUID) {
        mTournamentUUID.setValue(tournamentUUID);
        return mMatchesAssignedToTournament;
    }
}

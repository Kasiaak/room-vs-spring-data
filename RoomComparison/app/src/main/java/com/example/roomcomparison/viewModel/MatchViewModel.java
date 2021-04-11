package com.example.roomcomparison.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import com.example.roomcomparison.repository.MatchRepository;


public class MatchViewModel extends AndroidViewModel {
    private final MatchRepository mMatchRepository;

    public MatchViewModel(Application application) {
        super(application);
        mMatchRepository = new MatchRepository(application);
    }

    public void dummyQuery() {
        mMatchRepository.dummyQuery();
    }
}

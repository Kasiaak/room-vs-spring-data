package com.example.roomcomparison.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.roomcomparison.entity.player.Player;
import com.example.roomcomparison.repository.PlayerRepository;

import java.util.List;

public class PlayerViewModel extends AndroidViewModel {
    private final PlayerRepository mPlayerRepository;
    private final LiveData<List<Player>> mAllPlayers;

    public PlayerViewModel(Application application) {
        super(application);
        mPlayerRepository = new PlayerRepository(application);
        mAllPlayers = mPlayerRepository.getAllPlayers();
    }

    public LiveData<List<Player>> getAllPlayers() {
        return mAllPlayers;
    }

    public void insertPlayer(Player player) {
        mPlayerRepository.insertPlayer(player);
    }

    public void deleteAllPlayers() {
        mPlayerRepository.deleteAllPlayers();
    }

}

package com.example.roomcomparison.repository;

import android.app.Application;


import com.example.roomcomparison.dao.MatchDao;
import com.example.roomcomparison.database.RoomComparisonDatabase;

public class MatchRepository {
    private final MatchDao mMatchDao;

    public MatchRepository(Application application) {
        RoomComparisonDatabase db = RoomComparisonDatabase.getDatabase(application);
        mMatchDao = db.matchDao();
    }

    public void dummyQuery() {
        RoomComparisonDatabase.databaseWriteExecutor.execute(() -> {
            mMatchDao.dummyQuery();
        });
    }
}

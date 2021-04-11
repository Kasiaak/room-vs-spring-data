package com.example.roomcomparison.dao;

import androidx.room.Dao;
import androidx.room.Query;


@Dao
public interface MatchDao {
    @Query("SELECT 1")
    String dummyQuery();
}

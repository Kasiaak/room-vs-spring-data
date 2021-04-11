package com.example.roomcomparison.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "Tournament")
public class Tournament {
    @PrimaryKey
    @NonNull
    public String tournamentUUID;

    @ColumnInfo(name = "tournament_name")
    public String tournamentName;

    @ColumnInfo(name = "game_mode")
    public String gameMode;

}

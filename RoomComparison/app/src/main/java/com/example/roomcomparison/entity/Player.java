package com.example.roomcomparison.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Player {
    @PrimaryKey
    @NonNull
    public String playerUUID;

    @ColumnInfo(name = "player_name")
    public String playerName;
}

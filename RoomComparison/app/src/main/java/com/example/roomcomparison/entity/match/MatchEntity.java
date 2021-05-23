package com.example.roomcomparison.entity.match;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "MatchEntity")
public class MatchEntity {
    @PrimaryKey
    @NonNull
    public String matchUUID;

    @ColumnInfo(name = "player_one_id")
    public String player1Id;

    @ColumnInfo(name = "player_two_id")
    public String player2Id;

    @ColumnInfo(name = "player_one_points")
    public int player1Points;

    @ColumnInfo(name = "player_two_points")
    public int player2Points;

    @ColumnInfo(name = "tournamentUUIDFK")
    public String tournamentUUIDFK;

    @ColumnInfo(name = "match_ended")
    public boolean matchEnded;

}

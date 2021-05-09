package com.example.roomcomparison.entity.relations.manyToMany;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(primaryKeys = {"tournamentUUID", "playerUUID"})
public class TournamentPlayerCrossRefEntity {
    @NonNull
    public String tournamentUUID;
    @NonNull
    public String playerUUID;
}

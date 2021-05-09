package com.example.roomcomparison.entity.relations.manyToMany;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(primaryKeys = {"playerUUID", "matchUUID"})
public class MatchPlayerCrossRefEntity {
    @NonNull
    public String playerUUID;
    @NonNull
    public String matchUUID;
}

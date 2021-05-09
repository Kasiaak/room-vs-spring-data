package com.example.roomcomparison.entity;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.roomcomparison.entity.match.MatchEntity;
import com.example.roomcomparison.entity.player.Player;
import com.example.roomcomparison.entity.relations.manyToMany.MatchPlayerCrossRefEntity;

import java.util.List;

public class MatchWithPlayers {
    @Embedded
    public MatchEntity match;
    @Relation(
            parentColumn = "matchUUID",
            entityColumn = "playerUUID",
            associateBy = @Junction(MatchPlayerCrossRefEntity.class)
    )
    public List<Player> players;
}

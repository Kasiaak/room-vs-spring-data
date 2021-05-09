package com.example.roomcomparison.entity;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.roomcomparison.entity.player.Player;
import com.example.roomcomparison.entity.relations.manyToMany.TournamentPlayerCrossRefEntity;
import com.example.roomcomparison.entity.tournament.Tournament;

import java.util.List;

public class TournamentWithPlayers {
    @Embedded public Tournament tournament;
    @Relation(
            parentColumn = "tournamentUUID",
            entityColumn = "playerUUID",
            associateBy = @Junction(TournamentPlayerCrossRefEntity.class)
    )
    public List<Player> listOfTournamentsWithPlayers;
}
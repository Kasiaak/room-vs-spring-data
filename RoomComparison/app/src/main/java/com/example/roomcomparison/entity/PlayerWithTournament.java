package com.example.roomcomparison.entity;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.roomcomparison.entity.player.Player;
import com.example.roomcomparison.entity.relations.manyToMany.TournamentPlayerCrossRefEntity;
import com.example.roomcomparison.entity.tournament.Tournament;

import java.util.List;

public class PlayerWithTournament {
    @Embedded public Player player;
    @Relation(
            parentColumn = "playerId",
            entityColumn = "tournamentId",
            associateBy = @Junction(TournamentPlayerCrossRefEntity.class)
    )
    public List<Tournament> listOfPlayersWithTournaments;
}
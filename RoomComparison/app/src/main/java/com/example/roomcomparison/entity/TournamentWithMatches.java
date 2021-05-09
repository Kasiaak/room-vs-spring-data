package com.example.roomcomparison.entity;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.roomcomparison.entity.match.MatchEntity;
import com.example.roomcomparison.entity.tournament.Tournament;

import java.util.List;

public class TournamentWithMatches {
    @Embedded public Tournament tournament;
    @Relation(
            parentColumn = "tournamentUUID",
            entityColumn = "tournamentUUIDFK"
    )
    public List<MatchEntity> matchList;
}
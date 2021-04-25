package pl.kasiaak.spring_boot_learning.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerId;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "tournament_participation",
            joinColumns = @JoinColumn(name = "playerId"),
            inverseJoinColumns = @JoinColumn(name = "tournamentId"))
    List<Tournament> tournamentParticipation;

    @ManyToMany
    @JoinTable(
            name = "match_participation",
            joinColumns = @JoinColumn(name = "playerId"),
            inverseJoinColumns = @JoinColumn(name = "matchId"))
    List<MatchEntity> matchParticipation;

}

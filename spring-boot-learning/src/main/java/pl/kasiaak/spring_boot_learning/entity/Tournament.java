package pl.kasiaak.spring_boot_learning.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tournamentId;

    private String tournamentName;
    private String gameType;

    @ManyToMany(mappedBy = "tournamentParticipation")
    List<Player> playersAssignedToTournament;

    @OneToMany(targetEntity = MatchEntity.class)
    List<MatchEntity> matchesInTournament;
}

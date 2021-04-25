package pl.kasiaak.spring_boot_learning.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchId;

    private Long playerOneId;
    private Long playerTwoId;

    private Integer playerOnePoints;
    private Integer playerTwoPoints;

    @ManyToMany(mappedBy = "matchParticipation")
    List<Player> playersAssignedToMatch;

}

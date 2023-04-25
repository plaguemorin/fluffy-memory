package ca.screenshot.antagonistsp.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class ActorMasteryPower {
    @Id
    public UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    public Actor actor;

    @ManyToOne
    public MasteryPower power;

    public int numTimesUsed;
}

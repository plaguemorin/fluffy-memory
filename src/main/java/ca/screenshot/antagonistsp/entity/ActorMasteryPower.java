package ca.screenshot.antagonistsp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

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

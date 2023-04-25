package ca.screenshot.antagonistsp.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Actor {
    @Id
    @Column(name = "ACTOR_ID")
    public UUID id;

    public String name;
    public String ethnicity;
    public int age;

    @ManyToOne
    public SourceOfPower power;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "actor", cascade = CascadeType.ALL)
    public ActorSkill actorSkill;

    @OneToMany
    public Set<Descriptor> descriptors;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actor")
    public Set<ActorMasteryPower> powers;

    public Actor() {
        this.powers = new HashSet<>();
        this.descriptors = new HashSet<>();
        this.actorSkill = new ActorSkill();
    }

    public void addDescriptor(Descriptor descriptor) {
        if (descriptor == null) {
            throw new NullPointerException();
        }

        this.descriptors.add(descriptor);
    }

    public void addPower(MasteryPower power) {
        if (power == null) {
            throw new NullPointerException();
        }

        ActorMasteryPower actorMasteryPower = new ActorMasteryPower();
        actorMasteryPower.id = UUID.randomUUID();
        actorMasteryPower.actor = this;
        actorMasteryPower.numTimesUsed = 0;
        actorMasteryPower.power = power;

        this.powers.add(actorMasteryPower);
    }
}

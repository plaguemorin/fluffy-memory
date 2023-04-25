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

    @OneToMany
    public Set<Descriptor> descriptors;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "actor")
    public ActorAttributes attributes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actor")
    public Set<ActorMasteryPower> powers;


    public Actor() {
        this.powers = new HashSet<>();
        this.descriptors = new HashSet<>();
        this.attributes = new ActorAttributes(this);
    }

    public int calculateCosts() {
        int i = 0;

        for (Descriptor descriptor : descriptors) {
            i += descriptor.cost;
        }
        return i;
    }

    public Attributes calculateAttributes() {
        Attributes a = new Attributes();
        a.setAll(attributes.attributes);

        for (Descriptor descriptor : descriptors) {
            a.add(descriptor.attributes.attributes);
        }

        return a;
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

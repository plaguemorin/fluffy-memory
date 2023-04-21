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
        this.descriptors = new HashSet<>();
        this.attributes = new ActorAttributes(this);
    }

}

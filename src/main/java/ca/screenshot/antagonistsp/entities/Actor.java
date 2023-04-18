package ca.screenshot.antagonistsp.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Actor {
    @Id
    @Column(name = "ACTOR_ID")
    public int actorId;

    public String name;
    public String ethnicity;
    public int age;

    @OneToMany
    public Set<Descriptor> descriptors;

    public Attributes attributes;

    public int acrobatics;
    public int athletics;
    public int brutalFighting;
    public int finesseFighting;
    public int muscular;

    public int drive;
    public int longArms;
    public int sleightOfHands;
    public int smallArms;
    public int stealth;

    public int charm;
    public int deception;
    public int insight;
    public int intimidate;
    public int persuade;

    public int investigate;
    public int knowledge;
    public int medicine;
    public int survival;
    public int technicals;

}

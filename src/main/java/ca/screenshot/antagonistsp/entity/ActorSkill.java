package ca.screenshot.antagonistsp.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class ActorSkill {
    @Id
    public UUID actorId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    public Actor actor;

    public int acrobatics;
    public boolean acrobaticsFlagged;
    public int athletics;
    public boolean athleticsFlagged;
    public int brutalFighting;
    public boolean brutalFightingFlagged;
    public int finesseFighting;
    public boolean finesseFightingFlagged;
    public int muscular;
    public boolean muscularFlagged;

    public int drive;
    public boolean driveFlagged;
    public int longArms;
    public boolean longArmsFlagged;
    public int sleightOfHands;
    public boolean sleightOfHandsFlagged;
    public int smallArms;
    public boolean smallArmsFlagged;
    public int stealth;
    public boolean stealthFlagged;

    public int charm;
    public boolean charmFlagged;
    public int deception;
    public boolean deceptionFlagged;
    public int insight;
    public boolean insightFlagged;
    public int intimidate;
    public boolean intimidateFlagged;
    public int persuade;
    public boolean persuadeFlagged;

    public int investigate;
    public boolean investigateFlagged;
    public int knowledge;
    public boolean knowledgeFlagged;
    public int medicine;
    public boolean medicineFlagged;
    public int survival;
    public boolean survivalFlagged;
    public int technical;
    public boolean technicalFlagged;
}

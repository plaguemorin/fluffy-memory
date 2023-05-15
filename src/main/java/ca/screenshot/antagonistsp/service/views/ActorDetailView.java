package ca.screenshot.antagonistsp.service.views;

import ca.screenshot.antagonistsp.Constants;

import java.util.List;

public class ActorDetailView {
    public String id;
    public String displayName;
    public SourceOfPowerListing sourceOfPower;
    public Attributes attributes;

    public List<PowerByMastery> powers;
    public Skills skills;
    public Modifier modifierAge;
    public Modifier modifierSize;
    public Modifier handiness;
    public List<Modifier> quirksTalents;
    public List<Modifier> quirksFlaws;
    public List<Modifier> characterDescriptors;
    public List<QuestLog> logs;

    public int totalCost;
    public int availableXp;

    public ActorMovement healthy_movement;
    public ActorMovement half_movement;

    public int initiative;
    public int brutalHit;
    public int finesseHit;
    public int meleeImpact;
    public int dodge;
    public int resistance;
    public int health;
}

package ca.screenshot.antagonistsp.entity;

import jakarta.persistence.*;

import java.util.*;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actor")
    public List<ActorQuestLogItem> logItems;

    public Actor() {
        this.powers = new HashSet<>();
        this.descriptors = new HashSet<>();
        this.actorSkill = new ActorSkill();
        this.logItems = new ArrayList<>();
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

    public void addQuestLog(String desc, int xpDiff) {
        ActorQuestLogItem questLogItem = new ActorQuestLogItem();
        questLogItem.id = UUID.randomUUID();
        questLogItem.actor = this;
        questLogItem.displayOrder = this.logItems.size() + 1;
        questLogItem.description = desc;
        questLogItem.xp = xpDiff;

        this.logItems.add(questLogItem);
    }
}

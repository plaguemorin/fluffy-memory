package ca.screenshot.antagonistsp.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class SourceOfPower {
    @Id
    public UUID id;
    public String name;

    /**
     * This source of power makes you choose one of the mastery per group
     * ------
     * Like:
     * * Smoke and Mirrors
     * * Telekinesis or Dream Weaver or Toxin-Breather
     * * 1 Specialization
     * ------
     * Would be 3 groups
     * Group 1 would be Smoke and Mirrors
     * Group 2 would be Telekinesis, Dream Weaver, Toxin-Breather
     * Group 3 would be all the Specialization
     **/
    @OneToMany(cascade = CascadeType.ALL)
    public Set<SourceOfPowerMasteryGroup> masteryGroups;

    public SourceOfPower() {
        this.masteryGroups = new HashSet<>();
    }

    public SourceOfPower(String uuid, String name) {
        this();
        this.id = UUID.fromString(uuid);
        this.name = name;
    }

    public SourceOfPower(String uuid, String name, Collection<SourceOfPowerMasteryGroup> groups) {
        this(uuid, name);
        this.masteryGroups.addAll(groups);
    }
}

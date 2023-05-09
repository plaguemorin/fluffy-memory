package ca.screenshot.antagonistsp.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
public class Mastery {
    @Id
    public UUID id;
    public String name;
    @Enumerated(EnumType.STRING)
    public Type type;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent", cascade = CascadeType.ALL)
    public Set<MasteryPower> powers;

    public Mastery() {
        powers = new HashSet<>();
    }

    public Mastery(String id, String name, Type masteryType) {
        this();
        this.id = UUID.fromString(id);
        this.name = name;
        this.type = masteryType;
    }

    public Mastery(String id, String name, Type masteryType, Set<MasteryPower> powers) {
        this(id, name, masteryType);
        for (MasteryPower power : powers) {
            power.parent = this;
            this.powers.add(power);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mastery mastery = (Mastery) o;
        return Objects.equals(id, mastery.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public enum Type {
        MAJOR,
        MINOR,
        SPECIALIZE
    }
}

package ca.screenshot.antagonistsp.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class DescriptorAttributes {
    @Id
    public UUID descriptorId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    public Descriptor descriptor;

    @Embedded
    public Attributes attributes;

    public DescriptorAttributes() {
        this.attributes = new Attributes();
    }

    public DescriptorAttributes(Descriptor parent) {
        this();
        this.descriptor = parent;
    }

    public void setStrength(int strength) { this.attributes.strength = strength; }
    public void setConstitution(int constitution) { this.attributes.constitution = constitution; }
    public void setAgility(int agility) { this.attributes.agility = agility; }
    public void setPerception(int perception) { this.attributes.perception = perception; }
    public void setReflex(int reflex) { this.attributes.reflex = reflex; }
    public void setIntelligence(int intelligence) { this.attributes.intelligence = intelligence; }
    public void setCharisma(int charisma) { this.attributes.charisma = charisma; }
    public void setHeight(int height) { this.attributes.height = height; }
    public void setWeight(int weight) { this.attributes.weight = weight; }
}

package ca.screenshot.antagonistsp.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Descriptor {
    @Id
    @Column(name = "DESCRIPTOR_ID")
    public UUID descriptorId;

    @ManyToOne
    public Category category;
    public String name;
    public int cost;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "descriptor")
    public DescriptorAttributes attributes;

    public Descriptor() {
        this.attributes = new DescriptorAttributes(this);

        this.attributes.setStrength(0);
        this.attributes.setConstitution(0);
        this.attributes.setAgility(0);
        this.attributes.setPerception(0);
        this.attributes.setReflex(0);
        this.attributes.setIntelligence(0);
        this.attributes.setCharisma(0);
        this.attributes.setHeight(0);
        this.attributes.setWeight(0);
    }

    public Descriptor(Category category, String name, int cost) {
        this();
        this.descriptorId = UUID.randomUUID();

        this.category = category;
        this.name = name;
        this.cost = cost;
    }

    public Descriptor(Category category, String name, int cost, int modStr, int modCon, int modAgi, int modPer, int modRef, int modInt, int modCha, int modHeight, int modWeight) {
        this(category, name, cost);

        this.attributes.setStrength(modStr);
        this.attributes.setConstitution(modCon);
        this.attributes.setAgility(modAgi);
        this.attributes.setPerception(modPer);
        this.attributes.setReflex(modRef);
        this.attributes.setIntelligence(modInt);
        this.attributes.setCharisma(modCha);
        this.attributes.setHeight(modHeight);
        this.attributes.setWeight(modWeight);
    }
}
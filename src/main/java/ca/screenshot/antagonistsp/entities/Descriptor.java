package ca.screenshot.antagonistsp.entities;

import jakarta.persistence.*;

@Entity
public class Descriptor {
    @Id
    @GeneratedValue
    public int descriptorId;
    @ManyToOne
    public Category category;
    public String name;
    public int cost;

    public Attributes attributes;

    public Descriptor() {
        this.attributes = new Attributes();
    }

    public Descriptor(Category category, String name, int cost, int modStr, int modCon, int modAgi, int modPer, int modRef, int modInt, int modCha, int modHeight, int modWeight) {
        this.category = category;
        this.name = name;
        this.cost = cost;

        this.attributes = new Attributes();
        this.attributes.strength = modStr;
        this.attributes.constitution = modCon;
        this.attributes.agility = modAgi;
        this.attributes.perception = modPer;
        this.attributes.reflex = modRef;
        this.attributes.intelligence = modInt;
        this.attributes.charisma = modCha;
        this.attributes.height = modHeight;
        this.attributes.weight = modWeight;
    }
}
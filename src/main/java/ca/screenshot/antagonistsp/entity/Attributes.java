package ca.screenshot.antagonistsp.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Attributes {
    public int strength;
    public int constitution;
    public int agility;
    public int perception;
    public int reflex;
    public int intelligence;
    public int charisma;
    public int height;
    public int weight;

    public static Attributes Add(Attributes a, Attributes b) {
        Attributes ret = new Attributes();
        ret.setAll(a);
        ret.add(b);
        return ret;
    }

    public void add(Attributes other) {
        strength += other.strength;
        constitution += other.constitution;
        agility += other.agility;
        perception += other.perception;
        reflex += other.reflex;
        intelligence += other.intelligence;
        charisma += other.charisma;
        height += other.height;
        weight += other.weight;
    }

    public void setAll(Attributes attributes) {
        strength = attributes.strength;
        constitution = attributes.constitution;
        agility = attributes.agility;
        perception = attributes.perception;
        reflex = attributes.reflex;
        intelligence = attributes.intelligence;
        charisma = attributes.charisma;
        height = attributes.height;
        weight = attributes.weight;
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        if (strength != 0) buffer.append(strength).append("STR ");
        if (constitution != 0) buffer.append(constitution).append("CON ");
        if (agility != 0) buffer.append(agility).append("AGI ");
        if (perception != 0) buffer.append(perception).append("PER ");
        if (reflex != 0) buffer.append(reflex).append("REF ");
        if (intelligence != 0) buffer.append(intelligence).append("INT ");
        if (charisma != 0) buffer.append(charisma).append("CHA ");
        if (height != 0) buffer.append(height).append("HEI ");
        if (weight != 0) buffer.append(weight).append("WEI");

        return buffer.toString().trim();
    }
}

package ca.screenshot.antagonistsp.service.views;


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

    public Attributes() {
        strength = constitution = agility = perception = reflex =
                intelligence = charisma = height = weight = 0;
    }

    public void add(ca.screenshot.antagonistsp.entity.Attributes other) {
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

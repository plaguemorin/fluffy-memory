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
}

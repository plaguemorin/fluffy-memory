package ca.screenshot.antagonistsp.entities;

import jakarta.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue
    public int itemId;
    @ManyToOne
    public Category category;
    public String name;
    public int cost;
    public int modStr;
    public int modCon;
    public int modAgi;
    public int modPer;
    public int modRef;
    public int modInt;
    public int modCha;
    public int modHeight;
    public int modWeight;

    public Item() {}

    public Item(Category category, String name, int cost, int modStr, int modCon, int modAgi, int modPer, int modRef, int modInt, int modCha, int modHeight, int modWeight) {
        this.category = category;
        this.name = name;
        this.cost = cost;
        this.modStr = modStr;
        this.modCon = modCon;
        this.modAgi = modAgi;
        this.modPer = modPer;
        this.modRef = modRef;
        this.modInt = modInt;
        this.modCha = modCha;
        this.modHeight = modHeight;
        this.modWeight = modWeight;
    }
}
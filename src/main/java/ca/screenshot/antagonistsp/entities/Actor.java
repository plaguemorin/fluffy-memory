package ca.screenshot.antagonistsp.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Actor {
    @Id
    @Column(name = "ACTOR_ID")
    public int actorId;

    public String name;
    public String ethnicity;

    @OneToMany(mappedBy = "actor")
    Set<ActorItem> items;
}

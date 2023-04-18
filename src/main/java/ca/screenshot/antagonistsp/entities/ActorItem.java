package ca.screenshot.antagonistsp.entities;

import jakarta.persistence.*;

@Entity
public class ActorItem {
    @EmbeddedId
    ActorItemKey id;

    @ManyToOne
    @MapsId("actorId")
    @JoinColumn(name = "ACTOR_ID")
    Actor actor;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "ITEM_ID")
    Item item;


}

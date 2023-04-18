package ca.screenshot.antagonistsp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ActorItemKey implements Serializable {
    @Column(name = "ACTOR_ID")
    int actorId;

    @Column(name = "ITEM_ID")
    int itemId;


}

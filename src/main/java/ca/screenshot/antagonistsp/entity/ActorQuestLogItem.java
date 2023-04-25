package ca.screenshot.antagonistsp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

@Entity
public class ActorQuestLogItem {
    @Id
    public UUID id;

    @ManyToOne
    public Actor actor;

    public int displayOrder;
    public String description;
    public int xp;
}

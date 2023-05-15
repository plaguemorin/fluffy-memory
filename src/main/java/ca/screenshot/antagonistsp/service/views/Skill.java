package ca.screenshot.antagonistsp.service.views;

import java.util.Map;
import java.util.UUID;

public class Skill {
    private UUID id;
    private int level;
    private int attributeTotal;
    private boolean flagged;

    public Skill(UUID id) {
        this.id = id;
        this.level = 0;
        this.attributeTotal = 0;
        this.flagged = false;
    }

    private Skill(UUID skillID, int attributeTotal, int level, boolean flagged) {
        this.id = skillID;
        this.level = level;
        this.attributeTotal = attributeTotal;
        this.flagged = flagged;
    }

    public static Map.Entry<UUID, Skill> MakeSkillEntry(UUID skillID, int attributeTotal, int level, boolean flagged) {
        return Map.entry(skillID, new Skill(skillID, attributeTotal, level, flagged));
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public int getAttributeTotal() {
        return attributeTotal;
    }

    public void setAttributeTotal(int attributeTotal) {
        this.attributeTotal = attributeTotal;
    }

    public int getRating() {
        return attributeTotal + level;
    }
}

package ca.screenshot.antagonistsp.service.views;

import ca.screenshot.antagonistsp.Constants;

import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Skill {
    private UUID id;
    private int level;
    private boolean flagged;

    private Skill(UUID skillID, int level, boolean flagged) {
        this.id = skillID;
        this.level = level;
        this.flagged = flagged;
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

    public static Map.Entry<UUID, Skill> MakeSkillEntry(UUID skillID, int level, boolean flagged) {
        return Map.entry(skillID, new Skill(skillID, level, flagged));
    }

    public static Map<UUID, Skill> Add(Map<UUID, Skill> a, Map<UUID, Skill> b) {
        return Stream.of(a, b, MakeEmptySkillList())
                .flatMap(e -> e.entrySet().stream())
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (s1, s2) -> new Skill(
                                        s1.id,
                                        s1.level + s2.level,
                                        s1.flagged | s2.flagged
                                )
                        )
                );
    }

    public static Map<UUID, Skill> MakeEmptySkillList() {
        return Map.ofEntries(
                MakeSkillEntry(Constants.KNOWN_ID_SKILL_ACROBATICS, 0, false),
                MakeSkillEntry(Constants.KNOWN_ID_SKILL_ATHLETICS, 0, false),
                MakeSkillEntry(Constants.KNOWN_ID_SKILL_BRUTALFIGHTING, 0, false),
                MakeSkillEntry(Constants.KNOWN_ID_SKILL_FINESSEFIGHTING, 0, false),
                MakeSkillEntry(Constants.KNOWN_ID_SKILL_MUSCULAR, 0, false),

                MakeSkillEntry(Constants.KNOWN_ID_SKILL_DRIVE, 0, false),
                MakeSkillEntry(Constants.KNOWN_ID_SKILL_LONGARMS, 0, false),
                MakeSkillEntry(Constants.KNOWN_ID_SKILL_SLEIGHTOFHANDS, 0, false),
                MakeSkillEntry(Constants.KNOWN_ID_SKILL_SMALLARMS, 0, false),
                MakeSkillEntry(Constants.KNOWN_ID_SKILL_STEALTH, 0, false),

                MakeSkillEntry(Constants.KNOWN_ID_SKILL_CHARM, 0, false),
                MakeSkillEntry(Constants.KNOWN_ID_SKILL_DECEPTION, 0, false),
                MakeSkillEntry(Constants.KNOWN_ID_SKILL_INSIGHT, 0, false),
                MakeSkillEntry(Constants.KNOWN_ID_SKILL_INTIMIDATE, 0, false),
                MakeSkillEntry(Constants.KNOWN_ID_SKILL_PERSUADE, 0, false),

                MakeSkillEntry(Constants.KNOWN_ID_SKILL_INVESTIGATE, 0, false),
                MakeSkillEntry(Constants.KNOWN_ID_SKILL_KNOWLEDGE, 0, false),
                MakeSkillEntry(Constants.KNOWN_ID_SKILL_MEDICINE, 0, false),
                MakeSkillEntry(Constants.KNOWN_ID_SKILL_SURVIVAL, 0, false),
                MakeSkillEntry(Constants.KNOWN_ID_SKILL_TECHNICAL, 0, false)
        );
    }
}

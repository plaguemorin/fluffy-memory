package ca.screenshot.antagonistsp.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class MasteryPower {
    public enum Obviousness {
        NONE,
        LOW,
        MEDIUM,
        VERY_HIGH,
        HIGH,
    }

    public enum Range {
        TOUCH,
        LINE_OF_SIGHT,
        VOICE,
        SPECIAL,
        SELF,
        UNLIMITED,
        DREAM,
        CLOSE,
        SHORT,
        MEDIUM,
        LONG,
    }

    public enum Duration {
        NONE,
        ENCOUNTER,
        SUSTAIN_QUICK_ACTION,
        SUSTAIN_COMPLEX_ACTION,
        ROUND,
        SCENE,
        WEEK, PERMANENT,
    }

    @Id
    public UUID id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    public Mastery parent;

    public int level;

    public String name;

    @Enumerated(EnumType.STRING)
    public Obviousness obviousness;

    @Enumerated(EnumType.STRING)
    public Range range;

    @Enumerated(EnumType.STRING)
    public Duration duration;

    public int costToPurchase;

    public MasteryPower() {
    }

    public MasteryPower(String id, int level, String name, Obviousness obviousness, Range range, Duration duration, int cost) {
        this.id = UUID.fromString(id);

        this.level = level;
        this.name = name;
        this.obviousness = obviousness;
        this.range = range;
        this.costToPurchase = cost;
        this.duration = duration;
    }

    public MasteryPower(String id, int level, String name, Obviousness obviousness, Range range, int cost) {
        this(id, level, name, obviousness, range, Duration.NONE, cost);
    }

    public MasteryPower(String id, int level, String name, Obviousness obviousness, Range range) {
        this(id, level, name, obviousness, range, Duration.NONE, (level + (level + 1)) / 2);
    }

    public MasteryPower(String id, int level, String name, Obviousness obviousness, Range range, Duration duration) {
        this(id, level, name, obviousness, range);
        this.duration = duration;
    }
}

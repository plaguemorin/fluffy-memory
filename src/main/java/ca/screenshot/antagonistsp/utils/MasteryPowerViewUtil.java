package ca.screenshot.antagonistsp.utils;

import ca.screenshot.antagonistsp.entity.ActorMasteryPower;
import ca.screenshot.antagonistsp.entity.Mastery;
import ca.screenshot.antagonistsp.entity.MasteryPower;

import java.util.*;
import java.util.stream.Collectors;

public class MasteryPowerViewUtil {
    public static int MasteryTypeToPriority(Mastery.Type type) {
        return switch (type) {
            case MAJOR -> 0;
            case MINOR -> 1;
            case SPECIALIZE -> 2;
        };
    }

    public static List<PowerByMastery> OrderPowersByPowers(Set<ActorMasteryPower> actorMasteryPowers) {

        return actorMasteryPowers.stream().collect(
                Collectors.groupingBy(actorMasteryPower1 -> actorMasteryPower1.power.parent))
                .entrySet().stream()
                .map(entry -> {
                    PowerByMastery powerByMastery = new PowerByMastery();

                    powerByMastery.mastery = entry.getKey();
                    powerByMastery.powers = entry.getValue().stream()
                            .map(actorMasteryPower -> actorMasteryPower.power)
                            .sorted(Comparator.comparingInt(o -> o.level))
                            .toList();

                    if (!powerByMastery.powers.isEmpty()) {
                        powerByMastery.level = powerByMastery.powers.get(powerByMastery.powers.size() - 1).level;
                    }

                    return powerByMastery;
                })
                .sorted(Comparator.comparingInt(o -> MasteryTypeToPriority(o.mastery.type)))
                .toList();
    }

    public static class PowerByMastery {
        public Mastery mastery;
        public int level;
        public List<MasteryPower> powers;
    }

}

package ca.screenshot.antagonistsp.utils;

import ca.screenshot.antagonistsp.entity.ActorMasteryPower;
import ca.screenshot.antagonistsp.entity.Mastery;
import ca.screenshot.antagonistsp.entity.MasteryPower;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MasteryPowerViewUtil {
    public static class PowerByMastery {
        public Mastery mastery;
        public int level;
        public Set<MasteryPower> powers = new HashSet<>();
    }

    public static Set<PowerByMastery> OrderPowersByPowers(Set<ActorMasteryPower> actorMasteryPowers) {

        Set<PowerByMastery> powerByMastery =
                actorMasteryPowers.stream()
                        .map(amp -> amp.power.parent)
                        .map(m -> {
                            PowerByMastery byMastery = new PowerByMastery();
                            byMastery.powers = new HashSet<>();
                            return byMastery;
                        }).collect(Collectors.toSet());


        for (ActorMasteryPower amp : actorMasteryPowers) {
            PowerByMastery pbm = powerByMastery.stream()
                    .filter(powerByMastery1 -> powerByMastery1.mastery == amp.power.parent)
                    .findFirst()
                    .orElseGet(() -> {
                        PowerByMastery p = new PowerByMastery();
                        p.powers = new HashSet<>();
                        powerByMastery.add(p);
                        return p;
                    });

            pbm.powers.add(amp.power);
        }

        return powerByMastery;
    }

}

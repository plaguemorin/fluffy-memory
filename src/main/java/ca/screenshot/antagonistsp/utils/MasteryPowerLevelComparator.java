package ca.screenshot.antagonistsp.utils;

import ca.screenshot.antagonistsp.entity.MasteryPower;

import java.util.Comparator;

public class MasteryPowerLevelComparator implements Comparator<MasteryPower> {
    private final static MasteryPowerLevelComparator instance = new MasteryPowerLevelComparator();

    public static MasteryPowerLevelComparator create() {
        return instance;
    }

    @Override
    public int compare(MasteryPower o1, MasteryPower o2) {
        return Integer.compare(o1.level, o2.level);
    }
}

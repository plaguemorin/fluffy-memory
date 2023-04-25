package ca.screenshot.antagonistsp.service;

import ca.screenshot.antagonistsp.entity.SourceOfPower;
import ca.screenshot.antagonistsp.repository.SourceOfPowers;
import ca.screenshot.antagonistsp.service.views.SourceOfPowerListing;

public class SourceOfPowerView {
    private final SourceOfPowers repositorySourceOfPowers;

    public SourceOfPowerView(SourceOfPowers repositorySourceOfPowers) {
        this.repositorySourceOfPowers = repositorySourceOfPowers;
    }


    public static SourceOfPowerListing MakeListing(SourceOfPower power) {
        SourceOfPowerListing s = new SourceOfPowerListing();
        s.id = power.id.toString().toLowerCase();
        s.displayName = power.name;
        return s;
    }
}

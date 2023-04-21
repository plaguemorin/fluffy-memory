package ca.screenshot.antagonistsp.service;

import ca.screenshot.antagonistsp.repository.SourceOfPowers;
import org.springframework.stereotype.Service;

@Service
public class SourceOfPower {
    private SourceOfPowers sourceOfPowers;

    public SourceOfPower(SourceOfPowers sourceOfPowers) { this.sourceOfPowers = sourceOfPowers; }

}

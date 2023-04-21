package ca.screenshot.antagonistsp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.*;

@Entity
public class SourceOfPowerMasteryGroup {
    @Id
    public UUID id;
    public int displayOrder;

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<MasteryPower> powersAvailable;

    public SourceOfPowerMasteryGroup() {
        this.powersAvailable = new HashSet<>();
    }

    public SourceOfPowerMasteryGroup(Collection<MasteryPower> powersAvailable) {
        this();

        assert !powersAvailable.isEmpty();
        this.id = UUID.randomUUID();
        this.powersAvailable.addAll(powersAvailable);
    }
}

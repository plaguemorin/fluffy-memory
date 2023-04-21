package ca.screenshot.antagonistsp.repository;

import ca.screenshot.antagonistsp.entity.Mastery;
import ca.screenshot.antagonistsp.entity.MasteryPower;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;
import java.util.UUID;

public interface MasteryPowers extends CrudRepository<MasteryPower, UUID> {
    MasteryPower findByName(String name);
    Set<MasteryPower> findAllByParentTypeIs(Mastery.Type type);
    Set<MasteryPower> findAllByParentName(String parentName);
}

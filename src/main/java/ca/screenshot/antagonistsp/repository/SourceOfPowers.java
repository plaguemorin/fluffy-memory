package ca.screenshot.antagonistsp.repository;

import ca.screenshot.antagonistsp.entity.SourceOfPower;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SourceOfPowers extends CrudRepository<SourceOfPower, UUID> {
}

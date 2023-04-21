package ca.screenshot.antagonistsp.repository;

import ca.screenshot.antagonistsp.entity.Mastery;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface Masteries extends CrudRepository<Mastery, UUID> {
    Iterable<Mastery> findAllByType(Mastery.Type type);
}

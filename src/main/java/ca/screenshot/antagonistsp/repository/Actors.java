package ca.screenshot.antagonistsp.repository;

import ca.screenshot.antagonistsp.entity.Actor;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface Actors extends CrudRepository<Actor, UUID> {

}

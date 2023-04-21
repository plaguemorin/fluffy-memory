package ca.screenshot.antagonistsp.repository;

import ca.screenshot.antagonistsp.entity.Descriptor;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface Descriptors extends CrudRepository<Descriptor, UUID> {
    Iterable<Descriptor> findByCategory(String category);
}

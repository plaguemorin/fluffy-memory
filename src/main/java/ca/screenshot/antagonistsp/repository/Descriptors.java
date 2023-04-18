package ca.screenshot.antagonistsp.repository;

import ca.screenshot.antagonistsp.entities.Descriptor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Descriptors extends CrudRepository<Descriptor, Long> {
    List<Descriptor> findByCategory(String category);
    Descriptor findByItemId(long id);
}

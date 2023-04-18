package ca.screenshot.antagonistsp.repository;

import ca.screenshot.antagonistsp.entities.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Items extends CrudRepository<Item, Long> {
    List<Item> findByCategory(String category);
    Item findByItemId(long id);
}

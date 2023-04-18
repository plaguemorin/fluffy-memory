package ca.screenshot.antagonistsp.repository;

import ca.screenshot.antagonistsp.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Categories extends CrudRepository<Category, Long> {
    Category findByName(String name);

    List<Category> findCategoriesByParentCategory(Category category);
}

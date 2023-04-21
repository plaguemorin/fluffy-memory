package ca.screenshot.antagonistsp.repository;

import ca.screenshot.antagonistsp.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface Categories extends CrudRepository<Category, Long> {
    Category findByName(String name);

    Iterable<Category> findCategoriesByParentCategory(Category category);
}

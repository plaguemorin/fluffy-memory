package ca.screenshot.antagonistsp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Category {
    @Id
    @GeneratedValue
    public int categoryId;

    @ManyToOne(optional = true)
    public Category parentCategory;

    public String name;

    public Category() {
    }

    public Category(Category parentCategory, String name) {
        this.parentCategory = parentCategory;
        this.name = name;
    }
}

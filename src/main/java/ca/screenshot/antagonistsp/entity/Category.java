package ca.screenshot.antagonistsp.entity;

import jakarta.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue
    public int categoryId;

    @ManyToOne(optional = true)
    public Category parentCategory;

    public String name;

    public Category() {}

    public Category(Category parentCategory, String name) {
        this.parentCategory = parentCategory;
        this.name = name;
    }
}

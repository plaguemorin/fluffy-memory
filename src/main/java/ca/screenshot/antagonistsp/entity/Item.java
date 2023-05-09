package ca.screenshot.antagonistsp.entity;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER, name = "ITEM_TYPE")
@DiscriminatorValue("1")
public class Item {
    @Id
    @Column(name = "ITEM_ID")
    public UUID id;

    public String name;
    public Integer slug;
    public boolean stackable;

    @OneToMany
    public Set<Descriptor> descriptors;

}

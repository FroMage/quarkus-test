package org.quarkus.test.entities;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class ImportedEntity extends PanacheEntity {
    public String name;
}

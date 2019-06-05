package org.quarkus.test.app;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class DirectEntity extends PanacheEntity {
    public String name;
    public String name2;
    public String name3;
}

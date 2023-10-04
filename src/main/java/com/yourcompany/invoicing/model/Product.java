package com.yourcompany.invoicing.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.openxava.annotations.Required;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @Column(length = 9)
    int number;

    @Column(length = 50)
    @Required
    String description;
}

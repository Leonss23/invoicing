package com.yourcompany.invoicing.model;

import java.math.BigDecimal;
import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @DescriptionsList
    Category category;

    @Money
    BigDecimal price;

    @Files
    @Column(length = 32)
    String photos;

    @TextArea
    String remarks;

}

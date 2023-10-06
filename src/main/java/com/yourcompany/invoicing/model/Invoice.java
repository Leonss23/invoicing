package com.yourcompany.invoicing.model;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.yourcompany.invoicing.calculators.NextNumberForYearCalculator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Invoice {

    @Id
    @Hidden
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(length = 32)
    String oid;

    @Column(length = 4)
    @DefaultValueCalculator(CurrentYearCalculator.class)
    int year;

    @Column(length = 6)
    @DefaultValueCalculator(value = NextNumberForYearCalculator.class, properties = @PropertyValue(name = "year"))
    int number;

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    LocalDate date;

    @TextArea
    String remarks;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    Customer customer;

    @ElementCollection
    @ListProperties("product.number, product.description, quantity")
    Collection<Detail> details;
}

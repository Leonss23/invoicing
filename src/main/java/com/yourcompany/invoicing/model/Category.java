package com.yourcompany.invoicing.model;

import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.Hidden;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @Hidden
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(length = 32)
    String oid;

    @Column(length = 50)
    String description;
}

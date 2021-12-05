package org.forbrightfuture.rentahomebot.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "city")
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DESCRIPTION", length = 70)
    private String description;

    @Column(name = "ACTIVE")
    private Boolean active;

}

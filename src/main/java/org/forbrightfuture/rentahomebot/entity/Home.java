package org.forbrightfuture.rentahomebot.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "HOME")
@Data
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="LINK", length = 200, unique = true, nullable = false)
    private String link;

    @Column(name="IMAGE_LINK", length = 350)
    private String imageLink;

    @Column(name="PRICE")
    private Long price;

    @ManyToOne
    @JoinColumn(name = "CITY")
    private City city;

    @Column(name = "PLACE", length = 150)
    private String place;

    @Column(name="CATEGORY", length = 50)
    private String category;

    @Column(name="STAGE", length = 20)
    private String stage;

    @Column(name="ROOM")
    private Long numberOfRoom;

    @Column(name="AREA")
    private String area;

    @Column(name="TAGS")
    private String tags;

    @Lob
    @Column(name="INFO")
    private String info;

    @Column(name="ALREADY_SENT")
    private Boolean alreadySent;

    @Column(name="INSERT_DATE")
    private Date insertDate;

    @PrePersist
    public void doBeforePersist() {
        insertDate = new Date();
    }

}

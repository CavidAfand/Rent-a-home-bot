package org.forbrightfuture.rentahomebot.dto;

import lombok.Data;

@Data
public class HomeDTO {

    private String pageLink;
    private String imageLink;
    private Long price;
    private String place;
    private String category;
    private String stage;
    private Long numberOfRoom;
    private String area;
    private String tags;
    private String info;

}

package com.ratingService.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {

    @Id
    @Column(name="ID")
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

}

package com.ratingService.service;

import com.ratingService.entities.Rating;

import java.util.List;


public interface RatingService {

    //create
    Rating saveRating(Rating rating);

    //get all ratings
    List<Rating> getAllRatings();

    //get all rating by users
    List<Rating> getAllRatingByUserId(String userId);

    //get all rating by hotel
    List<Rating> getAllRatingByHotelId(String hotelId);

    //delete
    Rating deleteRating(String ratingId);

}

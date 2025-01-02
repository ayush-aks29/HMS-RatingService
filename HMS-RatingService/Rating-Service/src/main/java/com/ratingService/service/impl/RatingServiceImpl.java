package com.ratingService.service.impl;

import com.ratingService.exceptions.ResourceNotFoundException;
import com.ratingService.entities.Rating;
import com.ratingService.repository.RatingRepository;
import com.ratingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating saveRating(Rating rating) {
        String randomRatingId = UUID.randomUUID().toString();
        rating.setRatingId(randomRatingId);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getAllRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public Rating deleteRating(String ratingId) {
        Rating rating = ratingRepository.findById(ratingId).orElseThrow(
                ()-> new ResourceNotFoundException("Rating not found with Id: "+ratingId+" !!")
        );
        ratingRepository.delete(rating);
        return rating;
    }
}

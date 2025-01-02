package com.ratingService.controller;

import com.ratingService.entities.Rating;
import com.ratingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ratings")
public class RatingController {

    @Autowired
     private RatingService ratingService;

    //create
    @PostMapping("/addRating")
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.saveRating(rating));
    }

    //get all ratings
    @GetMapping("/getRating")
    public ResponseEntity<List<Rating>> getRatings(){
        List<Rating> allRatings = ratingService.getAllRatings();
        return ResponseEntity.ok(allRatings);
    }

    //get all ratings by user Id
    @GetMapping("/getRatingByUserId/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
        List<Rating> allRatings = ratingService.getAllRatingByUserId(userId);
        return ResponseEntity.ok(allRatings);
    }

    //get all ratings by hotel Id
    @GetMapping("/getRatingByHotelId/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
        List<Rating> allRatings = ratingService.getAllRatingByHotelId(hotelId);
        return ResponseEntity.ok(allRatings);
    }

    //delete Rating
    @DeleteMapping("/delete/{ratingId}")
    public ResponseEntity<Rating> deleteHotel(@PathVariable String ratingId) {
        Rating deletedRating = ratingService.deleteRating(ratingId);
        return ResponseEntity.ok(deletedRating);
    }









}

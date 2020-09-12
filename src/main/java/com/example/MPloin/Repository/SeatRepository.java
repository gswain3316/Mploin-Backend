package com.example.MPloin.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.MPloin.DataModel.Seat;

@Repository
public interface SeatRepository extends MongoRepository<Seat, Long> {

}

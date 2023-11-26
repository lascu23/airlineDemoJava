package com.airline.demo.repository;

import com.airline.demo.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByDateDepartAndDateArrival(String dateDepart, String dateArrival);
    List<Flight> findByDateDepartAndDateArrivalAndTakeOffLocationAndDestination(String dateDepart, String dateArrival,String takeOffLocation, String destination);

    List<Flight> findByTakeOffLocationAndDestination(String takeOffLocation, String destination);
}

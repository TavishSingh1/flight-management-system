package com.vit.fy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vit.fy.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	Optional<Flight> findByNumber(String number);
}

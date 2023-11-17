package com.vit.fy.service;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.vit.fy.dto.FlightDTO;
import com.vit.fy.entity.Flight;
import com.vit.fy.repository.FlightRepository;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;

	public void addFlight(FlightDTO flightDTO) {

		Flight flight = new Flight();
		flight.setNumber(flightDTO.getNumber());
		flight.setSource(flightDTO.getSource());
		flight.setDestination(flightDTO.getDestination());
		flightRepository.save(flight);
	}

	public List<FlightDTO> getFlight() {
		List<Flight> flights = flightRepository.findAll();
		List<FlightDTO> flightDTOs = new ArrayList<FlightDTO>();
		for (Flight flight : flights) {
			FlightDTO flightDTO = new FlightDTO();
			flightDTO.setDestination(flight.getDestination());
			flightDTO.setNumber(flight.getNumber());
			flightDTO.setId(flight.getId());
			flightDTO.setSource(flight.getSource());
			flightDTOs.add(flightDTO);
		}
		return flightDTOs;
	}

	public FlightDTO getFlightById(Long id) {
		FlightDTO flightDTO = new FlightDTO();
		Optional<Flight> optionalFlight = flightRepository.findById(id);
		Flight flight = optionalFlight.get();
		flightDTO.setId(flight.getId());
		flightDTO.setNumber(flight.getNumber());
		flightDTO.setSource(flight.getSource());
		flightDTO.setDestination(flight.getDestination());
		return flightDTO;
	}

	public void delById(Long id) {
		flightRepository.deleteById(id);
	}

	public void updateFlight(FlightDTO flightDTO) {

		Long id = flightDTO.getId();
		Optional<Flight> optionalFlight = flightRepository.findById(id);
		Flight flight = optionalFlight.get();
		flight.setNumber(flightDTO.getNumber());
		flight.setSource(flightDTO.getSource());
		flight.setDestination(flightDTO.getDestination());
		flightRepository.save(flight);
	}
	
	public FlightDTO getFlightByNumber(String fNumber){
		FlightDTO flightDTO = new FlightDTO();
		Optional<Flight> optionalFlight = flightRepository.findByNumber(fNumber);
		Flight flight = optionalFlight.get();
		flightDTO.setId(flight.getId());
		flightDTO.setNumber(flight.getNumber());
		flightDTO.setSource(flight.getSource());
		flightDTO.setDestination(flight.getDestination());
		return flightDTO;
	}
}

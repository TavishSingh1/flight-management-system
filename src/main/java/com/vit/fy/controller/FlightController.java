package com.vit.fy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.vit.fy.dto.FlightDTO;
import com.vit.fy.service.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController {

	List<FlightDTO> flightList = new ArrayList<FlightDTO>();

	@Autowired
	private FlightService flightService;

	@PostMapping
	public void addFlight(@RequestBody FlightDTO flight) {
		flightService.addFlight(flight);
	}

	@GetMapping
	public ResponseEntity<List<FlightDTO>> getFlight() {
		return ResponseEntity.ok(flightService.getFlight());
	}

	@GetMapping("/{id}")
	public ResponseEntity<FlightDTO> getFlightById(@PathVariable Long id) {

		return ResponseEntity.ok(flightService.getFlightById(id));
//		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Flight Not Found");
	}

	@GetMapping("/by-number")
	public ResponseEntity<FlightDTO> getFlightByNumber(@RequestParam String fNumber) {
		return ResponseEntity.ok(flightService.getFlightByNumber(fNumber));
	}

	@DeleteMapping("/{id}")
	public void delById(@PathVariable Long id) {
		flightService.delById(id);
	}

	@PutMapping
	public void updateFlight(@RequestBody FlightDTO flight) {
		flightService.updateFlight(flight);
	}
}

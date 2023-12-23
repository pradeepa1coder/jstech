package org.jsp.controller;

import java.util.List;

import org.jsp.dto.Position;
import org.jsp.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PositionController {

	@Autowired
	private PositionService positionService;

	@GetMapping("/getAllPositions")
	public List<Position> getAllPositions() {
		return positionService.getAllPositions();
	}

	@GetMapping("/getPositionById/{id}")
	public ResponseEntity<Position> getPositionById(@PathVariable Long id) {
		Position position = positionService.getPositionById(id);
		return ResponseEntity.ok(position);
	}

	@PostMapping("/createPosition")
	public ResponseEntity<Position> createPosition(@RequestBody Position position) {
		Position createdPosition = positionService.createPosition(position);
		return ResponseEntity.ok(createdPosition);
	}

	@PutMapping("/updatePosition/{id}")
	public ResponseEntity<Position> updatePosition(@PathVariable Long id, @RequestBody Position updatedPosition) {
		Position position = positionService.updatePosition(id, updatedPosition);
		return ResponseEntity.ok(position);
	}

	@DeleteMapping("/deletePosition/{id}")
	public ResponseEntity<Void> deletePosition(@PathVariable Long id) {
		positionService.deletePosition(id);
		return ResponseEntity.noContent().build();
	}
}

package org.jsp.controller;

import java.util.List;

import org.jsp.dto.Attendance;
import org.jsp.service.AttendanceService;
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
public class AttendanceController {

	@Autowired
	private AttendanceService attendanceService;

	@GetMapping("/getAllAttendances")
	public List<Attendance> getAllAttendances() {
		return attendanceService.getAllAttendances();
	}

	@GetMapping("/getAttendanceById/{id}")
	public ResponseEntity<Attendance> getAttendanceById(@PathVariable Long id) {
		Attendance attendance = attendanceService.getAttendanceById(id);
		return ResponseEntity.ok(attendance);
	}

	@PostMapping("/createAttendance")
	public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance attendance) {
		Attendance createdAttendance = attendanceService.createAttendance(attendance);
		return ResponseEntity.ok(createdAttendance);
	}

	@PutMapping("/updateAttendance/{id}")
	public ResponseEntity<Attendance> updateAttendance(@PathVariable Long id,
			@RequestBody Attendance updatedAttendance) {
		Attendance attendance = attendanceService.updateAttendance(id, updatedAttendance);
		return ResponseEntity.ok(attendance);
	}

	@DeleteMapping("/deleteAttendance/{id}")
	public ResponseEntity<Void> deleteAttendance(@PathVariable Long id) {
		attendanceService.deleteAttendance(id);
		return ResponseEntity.noContent().build();
	}
}

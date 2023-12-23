package org.jsp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.dto.Attendance;
import org.jsp.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id).orElse(null);
    }

    public Attendance createAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public Attendance updateAttendance(Long id, Attendance updatedAttendance) {
        Optional<Attendance> attendanceOptional = attendanceRepository.findById(id);
        if (attendanceOptional.isPresent()) {
            Attendance existingAttendance = attendanceOptional.get();
            existingAttendance.setIn_time(updatedAttendance.getIn_time());
            existingAttendance.setOut_time(updatedAttendance.getOut_time());

            return attendanceRepository.save(existingAttendance);
        } else {
            return null; 
        }
    }

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}


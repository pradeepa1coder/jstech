package org.jsp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.dto.Position;
import org.jsp.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    public Position getPositionById(Long id) {
        return positionRepository.findById(id).orElse(null);
    }

    public Position createPosition(Position position) {
        return positionRepository.save(position);
    }

    public Position updatePosition(Long id, Position updatedPosition) {
        Optional<Position> positionOptional = positionRepository.findById(id);
        if (positionOptional.isPresent()) {
            Position existingPosition = positionOptional.get();
            existingPosition.setName(updatedPosition.getName());
            existingPosition.setDepartment(updatedPosition.getDepartment()); 

            return positionRepository.save(existingPosition);
        } else {
            return null; 
        }
    }

    public void deletePosition(Long id) {
        positionRepository.deleteById(id);
    }
}


package com.enigma.betestmmi.service.position;

import com.enigma.betestmmi.entity.Position;
import com.enigma.betestmmi.repo.PositionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceDbImpl implements PositionService{

    @Autowired
    PositionRepo positionRepo;

    @Override
    public Position getDataById(Integer id) {
        return positionRepo.getPositionById(id);
    }

    @Override
    public List<Position> getAllData() {
        System.out.println("SAMPE SINI OKE");
        return positionRepo.getAllPosition();
    }

    @Override
    public Position createData(Position position) {
        return positionRepo.addPosition(position);
    }

    @Override
    public void deleteData(Integer id) {
        positionRepo.deletePositionById(id);
    }

    @Override
    public Position updateData(Position position) {
        return positionRepo.updatePosition(position);
    }
}

package com.enigma.betestmmi.controller;

import com.enigma.betestmmi.entity.Position;
import com.enigma.betestmmi.service.position.PositionServiceDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PositionController {
    @Autowired
    PositionServiceDbImpl positionServiceDb;

    @GetMapping("/positions")
    public List<Position> findAll() {
        return positionServiceDb.getAllData();
    }

    @PostMapping("/position")
    public Position create(@RequestBody Position position) {
        return positionServiceDb.createData(position);
    }

    @PutMapping("/position")
    public Position update(@RequestBody Position position) {
        positionServiceDb.updateData(position);
        return position;
    }

    @GetMapping("/position/{id}")
    public Position getPositionById(@PathVariable(name = "id") Integer id) {
        return positionServiceDb.getDataById(id);
    }

    @DeleteMapping("/position/{id}")
    public void delete(@PathVariable(name = "id") Integer id) {
        positionServiceDb.deleteData(id);
    }
}
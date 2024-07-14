package com.mapping.flood_impacts_mapping.controller;

import com.mapping.flood_impacts_mapping.entity.Agricultor;
import com.mapping.flood_impacts_mapping.service.AgricultorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agricultores")
public class AgricultorController {

    @Autowired
    AgricultorService agricultorService;

    @GetMapping
    public ResponseEntity<List<Agricultor>> getAllAgricultores() {
        List<Agricultor> agricultores = agricultorService.getAllAgricultores();
        return new ResponseEntity<>(agricultores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agricultor> getAgricultorById(@PathVariable int id) {
        Agricultor agricultor = agricultorService.getAgricultorById(id);
        if (agricultor == null) {
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<>(agricultor, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Agricultor> createAgricultor(@RequestBody Agricultor agricultor) {
        Agricultor createdAgricultor = agricultorService.createAgricultor(agricultor);
        return new ResponseEntity<>(createdAgricultor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agricultor> updateAgricultor(@PathVariable int id, @RequestBody Agricultor agricultor) {
        agricultor.setIdAgricultor(id);
        Agricultor updatedAgricultor = agricultorService.updateAgricultor(agricultor);
        return new ResponseEntity<>(updatedAgricultor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Agricultor> deleteAgricultor(@PathVariable int id) {
        agricultorService.deleteAgricultor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
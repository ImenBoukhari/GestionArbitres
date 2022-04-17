package com.example.GestionArbitre.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GestionArbitre.exception.ResourceNotFoundException;
import com.example.GestionArbitre.model.Arbitre;
import com.example.GestionArbitre.repository.ArbitreRepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ArbitreController {

    @Autowired
    private ArbitreRepository ArbitreRepository;

    // get all Arbitre
    @GetMapping("/arbitre")
    public List<Arbitre> getAllArbitre(){
        return ArbitreRepository.findAll();
    }

    // create arbitre rest api
    @PostMapping("/arbitre")
    public Arbitre createArbitre(@RequestBody Arbitre arbitre) {
        return ArbitreRepository.save(arbitre);
    }

    // get arbitre by id rest api
    @GetMapping("/arbitre/{id}")
    public ResponseEntity<Arbitre> getArbitreById(@PathVariable Long id) {
        Arbitre arbitre = ArbitreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Arbitre not exist with id :" + id));
        return ResponseEntity.ok(arbitre);
    }

    // update arbitre rest api

    @PutMapping("/arbitres/{id}")
    public ResponseEntity<Arbitre> updateArbitre(@PathVariable Long id, @RequestBody Arbitre arbitreDetails){
        Arbitre arbitre = ArbitreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Arbitre not exist with id :" + id));

        arbitre.setNiveau(arbitreDetails.getNiveau());
        arbitre.setFiliere(arbitreDetails.getFiliere());
        arbitre.setNom(arbitreDetails.getNom());
        arbitre.setPrenom(arbitreDetails.getPrenom());

        Arbitre updatedArbitre = ArbitreRepository.save(arbitre);
        return ResponseEntity.ok(updatedArbitre);
    }

    // delete Arbitre rest api
    @DeleteMapping("/arbitres/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteArbitre(@PathVariable Long id){
        Arbitre arbitre = ArbitreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Arbitre not exist with id :" + id));

        ArbitreRepository.delete(arbitre);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

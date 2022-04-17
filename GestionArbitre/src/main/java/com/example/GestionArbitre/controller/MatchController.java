package com.example.GestionArbitre.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.GestionArbitre.model.Arbitre;
import com.example.GestionArbitre.repository.ArbitreRepository;
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
import com.example.GestionArbitre.model.Match;
import com.example.GestionArbitre.repository.MatchRepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class MatchController {

    @Autowired
    private com.example.GestionArbitre.repository.MatchRepository MatchRepository;

    // get all match
    @GetMapping("/match")
    public List<Match> getAllMacth(){
        return MatchRepository.findAll();
    }

    // create macth rest api
    @PostMapping("/match")
    public Match createMatch(@RequestBody Match match) {
        return MatchRepository.save(match);
    }

    // get match by id rest api
    @GetMapping("/match/{id}")
    public ResponseEntity<Match> getMatchById(@PathVariable Long id) {
        Match match = MatchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not exist with id :" + id));
        return ResponseEntity.ok(match);
    }

    // update match rest api

    @PutMapping("/matchs/{id}")
    public ResponseEntity<Match> updateMacth(@PathVariable Long id, @RequestBody Match matchDetails){
        Match match = MatchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not exist with id :" + id));

        match.setDate(matchDetails.getDate());
        match.setArbitre_principal(matchDetails.getArbitre_principal());
        match.setNom_equipe1(matchDetails.getNom_equipe1());
        match.setNom_equipe2(matchDetails.getNom_equipe2());
        match.setResultat(matchDetails.getResultat());
        match.setTour(matchDetails.getTour());

        Match updatedMatch = MatchRepository.save(match);
        return ResponseEntity.ok(updatedMatch);
    }

    // delete Matchrest api
    @DeleteMapping("/matchs/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteMatch(@PathVariable Long id){
        Match match = MatchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not exist with id :" + id));

        MatchRepository.delete(match);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}

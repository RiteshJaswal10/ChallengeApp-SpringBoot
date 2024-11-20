package com.rj.ChallengeApp.controllers;

import com.rj.ChallengeApp.model.Challenge;
import com.rj.ChallengeApp.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallengeController
{
    @Autowired
    ChallengeService challengeService;

    @GetMapping
    public ResponseEntity<List<Challenge>> getAllChallenges()
    {
        return new ResponseEntity<>(challengeService.getAllChallenges(),HttpStatus.OK);
    }

    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallengeById(@PathVariable String month)
    {
        Challenge challenge = challengeService.getChallengeById(month);;
        if(challenge != null)
        {
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge)
    {
        boolean isAdded = challengeService.addChallenge(challenge);

        if(isAdded)
        {
            return new ResponseEntity<>("Challenge added successfully.",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Challenge not added.",HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/{id}")
    public void updateChallenge(@PathVariable Long id,
                                               @RequestBody Challenge updatedChallenge)
    {
        challengeService.updateChallenge(id,updatedChallenge);
    }

    @DeleteMapping("/{id}")
    public void deleteChallenge(@PathVariable Long id)
    {
        challengeService.deleteChallenge(id);
    }
}

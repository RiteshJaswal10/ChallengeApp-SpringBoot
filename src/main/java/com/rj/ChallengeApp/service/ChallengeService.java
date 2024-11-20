package com.rj.ChallengeApp.service;

import com.rj.ChallengeApp.model.Challenge;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService
{
    private List<Challenge> challenges = new ArrayList<>();
    private Long nextId = 1L;

    public List<Challenge> getAllChallenges()
    {
        return challenges;
    }

    public Challenge getChallengeById(String month)
    {
        for (Challenge challenge : challenges)
        {
            if(challenge.getMonth().equalsIgnoreCase(month))
            {
                return challenge;
            }
        }
        return null;
    }

    public boolean addChallenge(Challenge challenge)
    {
        if(challenge != null)
        {
            challenge.setId(nextId++);
            challenges.add(challenge);
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean updateChallenge(Long id, Challenge updatedChallenge)
    {
        for(Challenge challenge : challenges)
        {
            if(challenge.getId().equals(id))
            {
                challenge.setMonth(updatedChallenge.getMonth());
                challenge.setDescription(updatedChallenge.getDescription());

                return true;
            }
        }
        return false;
    }

    public boolean deleteChallenge(Long id)
    {
        return challenges.removeIf(challenge -> challenge.getId().equals(id));
//        for (Challenge challenge : challenges)
//        {
//            if(challenge.getId().equals(id))
//            {
//                challenges.remove(challenge);
//                return true;
//            }
//        }
//        return false;
    }
}

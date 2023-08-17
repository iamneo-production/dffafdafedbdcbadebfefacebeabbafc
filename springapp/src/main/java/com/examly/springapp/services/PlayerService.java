package com.examly.springapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.entities.PlayerDetails;
import com.examly.springapp.repositories.Playerrepo;

@Service
public class PlayerService {

@Autowired
private Playerrepo repo;

public PlayerDetails addPlayer(PlayerDetails player)
{
    return repo.save(player);
}


public List <PlayerDetails> getallPlayers()
{
    return repo.findAll();
}


public PlayerDetails update(PlayerDetails player,int id){
    return repo.save(player);
 }


public boolean deletePlayer(int id)
{
    try{
        repo.deleteById((long) id);
        return true;
    }catch(Exception e)
    {
        return false;
    }
}
}
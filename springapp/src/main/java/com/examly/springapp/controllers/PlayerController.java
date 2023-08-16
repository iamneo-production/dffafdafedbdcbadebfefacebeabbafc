package com.examly.springapp.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.entities.PlayerDetails;
import com.examly.springapp.services.PlayerService;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService service;


    @PostMapping("player/add")
    private boolean addPlayer(@RequestBody PlayerDetails player)
    {
       
       return service.addPlayer(player)!=null?true:false;
    }
    

    @GetMapping("player/getall")
    private List <PlayerDetails> getallPlayers()
    {
        return service.getallPlayers();
    }


    @PutMapping("player/update/{id}")
    private PlayerDetails updatPlayer(@RequestBody PlayerDetails player,@PathVariable int id)
    {
        return service.update(player,id);
    }


    @DeleteMapping("player/delete/{id}")
    private boolean deletePlayer(@PathVariable int id)
    {
        return service.deletePlayer(id);
    }

}

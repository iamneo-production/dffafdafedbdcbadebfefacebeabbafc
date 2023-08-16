package com.examly.springapp.repositories;


import com.examly.springapp.entities.Player;
import com.examly.springapp.entities.PlayerDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Playerrepo extends JpaRepository<PlayerDetails, Long> {


}

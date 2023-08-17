package com.examly.springapp.repositories;


import com.examly.springapp.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByCategoryAndSoldFalse(String category);
    List<Player> findBySoldFalse();
    List<Player> findByTeamId(Long teamId);
    List<Player> findBySoldTrue();

}

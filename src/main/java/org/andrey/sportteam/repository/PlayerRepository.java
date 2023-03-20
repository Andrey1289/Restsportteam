package org.andrey.sportteam.repository;

import org.andrey.sportteam.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long> {

}

package org.andrey.sportteam.repository;

import org.andrey.sportteam.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {
    public List<Player> findAllByteamId(Long id);
    public List<Player> findAllByroleIgnoreCase(String role);
    public Long deleteByid(Long id);
    public Player findByLastNameAndNameIgnoreCase(String lastName, String name);

}

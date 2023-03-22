package org.andrey.sportteam.repository;

import org.andrey.sportteam.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {

    public void deleteByteamNameIgnoreCase(String name);
    public List<Team> findAllBysportNameIgnoreCase(String sportName);
    public Team findByteamNameIgnoreCase(String teamName);
   public List<Team> findAllByfoundingDateStartingWith(Date date);
}

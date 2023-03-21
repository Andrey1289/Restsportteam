package org.andrey.sportteam.repository;

import org.andrey.sportteam.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {

    public void deleteByteameName(String name);
}

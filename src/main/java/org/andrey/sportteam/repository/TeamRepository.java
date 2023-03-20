package org.andrey.sportteam.repository;

import org.andrey.sportteam.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {
}

package org.andrey.sportteam.service.impl;

import org.andrey.sportteam.model.Team;
import org.andrey.sportteam.repository.TeamRepository;
import org.andrey.sportteam.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;

    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team createTeam(Team team) {

        return teamRepository.save(team);
    }

    @Override
    public Team updateTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void deleteTeam(String teamName) {
        teamRepository.deleteByteameName(teamName);

    }
}

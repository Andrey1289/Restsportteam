package org.andrey.sportteam.service.impl;

import org.andrey.sportteam.model.Team;
import org.andrey.sportteam.repository.PlayerRepository;
import org.andrey.sportteam.service.TeamService;

import java.util.List;

public class TeamServiceImpl implements TeamService {
    private final PlayerRepository playerRepository;

    public TeamServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Team> getAllTeams() {
        return null;
    }

    @Override
    public Team createTeam(Team team) {
        return null;
    }

    @Override
    public Team updateTeam(Team team) {
        return null;
    }

    @Override
    public void deleteTeam(String teamName) {

    }
}

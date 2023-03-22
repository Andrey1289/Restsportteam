package org.andrey.sportteam.service.impl;

import org.andrey.sportteam.model.Team;
import org.andrey.sportteam.repository.TeamRepository;
import org.andrey.sportteam.service.TeamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    public List<Team> getTeamBySportName(String sportName) {
        return teamRepository.findAllBysportNameIgnoreCase(sportName);
    }

    @Override
    public List<Team> getAllTeamStartingWithDate(Date date) {
        return teamRepository.findAllByfoundingDateStartingWith(date);
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
    @Transactional
    public void deleteTeam(String teamName) {
        teamRepository.deleteByteamNameIgnoreCase(teamName);

    }
}

package org.andrey.sportteam.service;

import org.andrey.sportteam.model.Team;

import java.util.Date;
import java.util.List;

public interface TeamService {

    public List<Team> getAllTeams();
    public List<Team> getTeamBySportName(String sportName);
    public List<Team> getAllTeamStartingWithDate(Date date);
    public Team createTeam(Team team);
    public Team updateTeam(Team team);
    public void deleteTeam(String teamName);

}

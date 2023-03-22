package org.andrey.sportteam.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.andrey.sportteam.model.Team;


import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeamDTO {

    public String teamName;
    public String sportName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    public Date foundingDate;

    public static TeamDTO fromTeam(Team team){
         TeamDTO teamDTO = new TeamDTO();
         teamDTO.setTeamName(team.getTeamName());
         teamDTO.setSportName(team.getSportName());
         teamDTO.setFoundingDate(team.getFoundingDate());

         return teamDTO;
    }

    public static Team toTeam(TeamDTO teamDTO){
        Team team = new Team();
         team.setTeamName(teamDTO.getTeamName());
         team.setSportName(teamDTO.getSportName());
         team.setFoundingDate(teamDTO.foundingDate);

        return team;
    }

    public static List<TeamDTO> teamDTOList(List<Team> teamList){
     List<TeamDTO> teamDTOS = new ArrayList<>();
      teamList.forEach(team -> teamDTOS.add(fromTeam(team)));
      return teamDTOS;
    }

    public static boolean isValid(TeamDTO teamDTO){
        if(teamDTO.getTeamName() == null){
            return false;
        }
        if(teamDTO.getSportName() == null){
            return false;
        }
        if(teamDTO.foundingDate == null){
            return false;
        }
        return true;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public Date getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(Date foundingDate) {
        this.foundingDate = foundingDate;
    }
}

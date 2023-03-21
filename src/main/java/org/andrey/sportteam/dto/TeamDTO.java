package org.andrey.sportteam.dto;

import org.andrey.sportteam.model.Team;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeamDTO {

    public String teamName;
    public String sportName;
    public Date  foundingData;

    public static TeamDTO fromTeam(Team team){
         TeamDTO teamDTO = new TeamDTO();
         teamDTO.setTeamName(teamDTO.getTeamName());
         teamDTO.setSportName(team.getSportName());
         teamDTO.setFoundingData(team.getFoundingDate());

         return teamDTO;
    }

    public static Team toTeam(TeamDTO teamDTO){
        Team team = new Team();
         team.setTeamName(teamDTO.getTeamName());
         team.setSportName(teamDTO.getSportName());
         team.setFoundingDate((Date) teamDTO.foundingData);

        return team;
    }

    public static List<TeamDTO> teamDTOList(List<Team> teamList){
     List<TeamDTO> teamDTOS = new ArrayList<>();
      teamList.forEach(team -> teamDTOS.add(fromTeam(team)));
      return teamDTOS;
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

    public Date getFoundingData() {
        return foundingData;
    }

    public void setFoundingData(Date foundingData) {
        this.foundingData = foundingData;
    }
}

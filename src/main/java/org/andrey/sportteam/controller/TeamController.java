package org.andrey.sportteam.controller;

import liquibase.repackaged.org.apache.commons.lang3.time.DateUtils;
import org.andrey.sportteam.dto.TeamDTO;
import org.andrey.sportteam.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<List<TeamDTO>> getAllTeam(){

        List<TeamDTO> teamDTOList = TeamDTO.teamDTOList(teamService.getAllTeams());
           if(teamDTOList.isEmpty()){
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
           }
        return new ResponseEntity<>(teamDTOList,HttpStatus.OK);
    }
   @GetMapping("{sportName}")
    public ResponseEntity<List<TeamDTO>> getTeamBySportName(@PathVariable String sportName){
           if(sportName == null){
               return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
           }

          List<TeamDTO> teamDTOList = TeamDTO.teamDTOList(teamService.getTeamBySportName(sportName));
           if(teamDTOList.isEmpty()){
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
           }
        return new ResponseEntity<>(teamDTOList,HttpStatus.OK);
    }
    @GetMapping("date/{date}")
    public ResponseEntity<List<TeamDTO>> getAllTeamPeriodOfTime(@PathVariable Date date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        System.out.println(date);
        List<TeamDTO> teamDTOList = TeamDTO.teamDTOList(teamService.getAllTeamStartingWithDate(date));
        return new ResponseEntity<>(teamDTOList,HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<TeamDTO> createTeam(@RequestBody TeamDTO teamDTO){
             if(!TeamDTO.isValid(teamDTO)){
                 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
             }
            teamDTO = TeamDTO.fromTeam(teamService.createTeam(TeamDTO.toTeam(teamDTO)));

        return new ResponseEntity<>(teamDTO,HttpStatus.OK);
    }
    @DeleteMapping("delete/{name}")
    public ResponseEntity<TeamDTO> deleteTeam(@PathVariable String name){
         if(name == null){
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
         }
         teamService.deleteTeam(name);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}

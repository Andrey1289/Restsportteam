package org.andrey.sportteam.controller;

import org.andrey.sportteam.dto.TeamDTO;
import org.andrey.sportteam.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<TeamDTO>> getAllTeam(){

        return null;
    }

    @PostMapping("create")
    public ResponseEntity<TeamDTO> createTeam(@RequestBody TeamDTO teamDTO){

        return null;
    }

}

package org.andrey.sportteam.controller;

import org.andrey.sportteam.dto.PlayerDTO;
import org.andrey.sportteam.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/players")
public class PlayerController {
     private final PlayerService playerService;

     @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<PlayerDTO>> getAllPlayers(){

        return null;
    }

    @PostMapping("create")
    public ResponseEntity<PlayerDTO> createPlayer(@RequestBody PlayerDTO playerDTO){
            if(playerDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            playerDTO =PlayerDTO.fromPlayer(playerService.createPlayer(PlayerDTO.toPlayer(playerDTO)));

        return new ResponseEntity<>(playerDTO,HttpStatus.OK);
    }

}

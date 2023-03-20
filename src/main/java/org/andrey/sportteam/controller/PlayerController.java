package org.andrey.sportteam.controller;

import org.andrey.sportteam.dto.PlayerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/players")
public class PlayerController {

    @GetMapping("getAll")
    public ResponseEntity<List<PlayerDTO>> getAllPlayers(){

        return null;
    }

    @PostMapping("create")
    public ResponseEntity<PlayerDTO> createPlayer(@RequestBody PlayerDTO playerDTO){

        return null;
    }

}

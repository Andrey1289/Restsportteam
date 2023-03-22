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


    @GetMapping
    public ResponseEntity<List<PlayerDTO>> getAllPlayers(){

         List<PlayerDTO> playerDTOList = (PlayerDTO.playerDTOList(playerService.getAllPlayers()));
         if(playerDTOList.isEmpty()){
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
        return new ResponseEntity<>(playerDTOList,HttpStatus.OK);
    }
    @GetMapping("{teamName}")
    public ResponseEntity<List<PlayerDTO>> getAllPlayersByTeamName(@PathVariable String teamName){
         List<PlayerDTO> playerDTOList = PlayerDTO.playerDTOList(playerService.getAllPlayersByTeamName(teamName));
          if(playerDTOList.isEmpty()){
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }

         return new ResponseEntity<>(playerDTOList,HttpStatus.OK);
    }
    @GetMapping("filter/{role}")
    public ResponseEntity<List<PlayerDTO>> getAllPlayersByRoll(@PathVariable String roll){
        List<PlayerDTO> playerDTOList = PlayerDTO.playerDTOList(playerService.getAllPlayersByTeamName(roll));


        return new ResponseEntity<>(playerDTOList,HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<PlayerDTO> createPlayer(@RequestBody PlayerDTO playerDTO){
            if(!PlayerDTO.isValid(playerDTO)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            playerDTO =PlayerDTO.fromPlayer(playerService.createPlayer(PlayerDTO.toPlayer(playerDTO)));

        return new ResponseEntity<>(playerDTO,HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<PlayerDTO> deletePlayer(@PathVariable Long id){
         if(id ==null){
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
         }
         playerService.deletePlayer(id);

         return new ResponseEntity<>(HttpStatus.OK);
    }

}

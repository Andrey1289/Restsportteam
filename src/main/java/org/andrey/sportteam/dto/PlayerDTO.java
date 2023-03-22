package org.andrey.sportteam.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.andrey.sportteam.model.Player;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PlayerDTO {

    private Long id;
    private Long teamId;
    private String lastName;
    private String name;
    private String middleName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date birthDay;
    private String role;

    public static PlayerDTO fromPlayer(Player player){
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setId(player.getId());
        playerDTO.setTeamId(player.getTeamId());
        playerDTO.setLastName(player.getLastName());
        playerDTO.setName(player.getName());
        playerDTO.setMiddleName(player.getMiddleName());
        playerDTO.setBirthDay(player.getBirthDay());
        playerDTO.setRole(player.getRole());

        return playerDTO;
    }

    public static Player toPlayer(PlayerDTO playerDTO){
        Player player = new Player();
        player.setTeamId(playerDTO.getTeamId());
        player.setLastName(playerDTO.getLastName());
        player.setName(playerDTO.getName());
        player.setMiddleName(playerDTO.getMiddleName());
        player.setBirthDay(playerDTO.getBirthDay());
        player.setRole(playerDTO.getRole());


        return player;
    }

    public static List<PlayerDTO> playerDTOList(List<Player> playerList){
        List<PlayerDTO> playerDTOS = new ArrayList<>();
        playerList.forEach(player -> playerDTOS.add(fromPlayer(player)));
        return playerDTOS;

    }

    public static boolean isValid(PlayerDTO playerDTO){
       if(playerDTO.getLastName() == null){
           return false;
       }
       if(playerDTO.getName()== null){
            return false;
        }
        if (playerDTO.getMiddleName()== null){
           return false;
        }
       if (playerDTO.getBirthDay()== null) {
           return false;
       }
        if(playerDTO.getRole()== null) {
            return false;
        }
                return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

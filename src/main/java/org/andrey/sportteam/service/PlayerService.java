package org.andrey.sportteam.service;

import org.andrey.sportteam.model.Player;

import java.util.List;

public interface PlayerService {

    public List<Player> getAllPlayers();
    public List<Player> getAllPlayersByTeamName(String teamName);
    public List<Player> getAllPlayersByPlayerRole(String role);
    public Player createPlayer(Player player);
    public Player updatePlayer(Player player);
    public Long deletePlayer(Long id);
    public Player transferPlayer(Player player, String teamEnrollment);

}

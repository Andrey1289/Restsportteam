package org.andrey.sportteam.service;

import org.andrey.sportteam.model.Player;

import java.util.List;

public interface PlayerService {

    public List<Player> getAllPlayers();
    public Player createPlayer(Player player);
    public Player updatePlayer(Player player);
    public void deletePlayer(Long id);
    public Player transferPlayer(Player player);

}

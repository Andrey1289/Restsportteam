package org.andrey.sportteam.service.impl;

import org.andrey.sportteam.model.Player;
import org.andrey.sportteam.repository.PlayerRepository;
import org.andrey.sportteam.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player updatePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void deletePlayer(Long id) {
      playerRepository.deleteById(id);
    }

    @Override
    public Player transferPlayer(Player transferPlayer) {

        return playerRepository.save(transferPlayer);
    }
}

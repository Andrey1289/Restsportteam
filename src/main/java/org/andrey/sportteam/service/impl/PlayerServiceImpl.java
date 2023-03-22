package org.andrey.sportteam.service.impl;

import org.andrey.sportteam.model.Player;
import org.andrey.sportteam.model.Team;
import org.andrey.sportteam.repository.PlayerRepository;
import org.andrey.sportteam.repository.TeamRepository;
import org.andrey.sportteam.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }


    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public List<Player> getAllPlayersByTeamName(String teamName) {
        Team team = teamRepository.findByteamNameIgnoreCase(teamName);

        return playerRepository.findAllByteamId(team.getId());
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

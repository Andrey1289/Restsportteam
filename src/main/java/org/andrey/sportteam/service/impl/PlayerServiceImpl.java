package org.andrey.sportteam.service.impl;

import org.andrey.sportteam.model.Player;
import org.andrey.sportteam.model.Team;
import org.andrey.sportteam.repository.PlayerRepository;
import org.andrey.sportteam.repository.TeamRepository;
import org.andrey.sportteam.service.PlayerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Player> getAllPlayersByPlayerRole(String role) {

        return playerRepository.findAllByroleIgnoreCase(role);
    }

    @Override
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player updatePlayer(Player player) {
        Player updatePlayer = playerRepository.findById(player.getId()).orElseThrow(null);

        if(player.getLastName() != null){
             updatePlayer.setLastName(player.getLastName());
         }
         if(player.getName() != null){
             updatePlayer.setName(player.getName());
         }
        if (player.getMiddleName() != null) {
            updatePlayer.setMiddleName(player.getMiddleName());
        }
        if(player.getRole() !=null){
            updatePlayer.setRole(player.getRole());
        }

        return playerRepository.save(updatePlayer);
    }

    @Override
    @Transactional
    public Long deletePlayer(Long id) {
    return playerRepository.deleteByid(id);
    }

    @Override
    public Player transferPlayer(Player transferPlayer,String teamEnrollment) {
        Player transfPlayer = playerRepository.findByLastNameAndNameIgnoreCase(transferPlayer.getLastName(),transferPlayer.getName());
        Team enrollTeam = teamRepository.findByteamNameIgnoreCase(teamEnrollment);
        if(enrollTeam != null){
            transfPlayer.setTeamId(enrollTeam.getId());
        }


        return playerRepository.save(transfPlayer);
    }
}

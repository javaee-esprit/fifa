package com.fifa.services;

import java.util.List;

import javax.ejb.Remote;

import com.fifa.persistence.Player;
import com.fifa.persistence.Team;

@Remote
public interface PlayerServiceRemote {
	
	void create(Player player);
	Player findPlayerById(int id);
	void update(Player player);
	void remove(Player player);
	void removePlayer(int id);
	List<Player> findAllPlayers();
	
	
	void create(Team team);
	Team findTeamById(int id);
	void update(Team team);
	void remove(Team team);
	void removeTeam(int id);
	List<Team> findAllTeams();
	
	List<Player> findPlayersByTeam(Team team);
	void transfer(Player player, Team team);
	void free(Player player);
	

}

package com.fifa.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.sql.DataSource;

import com.fifa.persistence.Player;
import com.fifa.persistence.Team;

@Stateless
public class PlayerService implements PlayerServiceRemote, PlayerServiceLocal {

	@PersistenceContext
	private EntityManager em;
	
	
    public PlayerService()  {
    }

	public void create(Player player) {
		em.persist(player);
		//player.setName("Isam Jemaa");
	}

	public Player findPlayerById(int id) {
		return em.find(Player.class, id);
	}

	public void update(Player player) {
		Player managedplayer =  em.merge(player);
//		player.setName("Isam Jemaa");
//		managedplayer.setName("Issam Jemaa");
	}

	public void remove(Player player) {
		em.remove(em.merge(player));
	}

	public void removePlayer(int id) {
		em.remove(em.find(Player.class, id));
	}

	public List<Player> findAllPlayers() {
//		List<Player> allPlayers = null;
//		String jpql = "select p from Player p";
//		TypedQuery<Player> query = em.createQuery(jpql, Player.class);
//		allPlayers = query.getResultList();
//		return allPlayers;
		return em.createQuery("select p from Player p", Player.class).getResultList();
	}

	public void create(Team team) {
		em.persist(team);
	}

	public Team findTeamById(int id) {
		
		return em.find(Team.class, id);
	}

	public void update(Team team) {
		em.merge(team);
	}

	public void remove(Team team) {
		em.remove(em.merge(team));
	}

	public void removeTeam(int id) {
		em.remove(findTeamById(id));
	}

	public List<Team> findAllTeams() {
		return em.createQuery("select t from Team t", Team.class ).getResultList();
	}

	public List<Player> findPlayersByTeam(Team team) {
//		List<Player> allPlayers = null;
//		String jpql = "select p from Player p where p.team=:x";
//		TypedQuery<Player> query = em.createQuery(jpql, Player.class);
//		query.setParameter("x", team);
//		allPlayers = query.getResultList();
//		return allPlayers;
		return em.createQuery("select p from Player p where p.team=:x", Player.class ).setParameter("x", team).getResultList();
		
	}

	public void transfer(Player player, Team team) {
//1 OK  Player p0 = em.merge(player);
//		p0.setTeam(team);
		
//2 KO	em.merge(player);
//		player.setTeam(team);
		
//3 OK	player.setTeam(team);
//		em.merge(player);
		
/* vert*/		player.setTeam(team);
		
/* bleu*/		List<Player> list = new ArrayList<>();
/* bleu*/		list.add(player);
/* bleu*/		team.setPlayers(list);
		
		em.merge(team);
	}

	public void free(Player player) {
		player.setTeam(null);
		em.merge(player);
	}

}

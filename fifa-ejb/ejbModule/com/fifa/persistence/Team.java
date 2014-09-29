package com.fifa.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="t_team")
public class Team implements Serializable {

	
	private int id;
	private String name;
	
	private List<Player> players;

	public Team() {
	}
	
	
	public Team(int id, String name) {
		this.id = id;
		this.name = name;
	}


	@Id    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@OneToMany( mappedBy = "team" , fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	public List<Player> getPlayers() {
		return players;
	}


	public void setPlayers(List<Player> players) {
		this.players = players;
	}


	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
	
	@PreRemove
	public void preRemove(){
		for(Player player : this.getPlayers()){
			player.setTeam(null);
		}
	}
   
	
}

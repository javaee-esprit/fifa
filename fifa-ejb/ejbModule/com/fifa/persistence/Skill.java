package com.fifa.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="t_skill")

public class Skill implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	
	private List<Player> players;

	public Skill() {
	}  
	
	
	public Skill(String name) {
		this.name = name;
	}


	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
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


	@ManyToMany( mappedBy = "skills" )
	public List<Player> getPlayers() {
		return players;
	}


	public void setPlayers(List<Player> players) {
		this.players = players;
	}


	public String toString() {
		return "Skill [id=" + id + ", name=" + name + "]";
	}
	
   
}

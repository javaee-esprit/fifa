package com.fifa.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table( name = "t_player" )
public class Player implements Serializable{
	
	
	private int id;
	private String name;
	private String position;
	private int number;
	private Date birthDate;
	private int age;
	private byte[] picture;
	private String description;
	
	private Team team;
	
	private List<Skill> skills;
	
	public Player() {
	}
	
	
	
	public Player(int id, String name, String position, int number) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.number = number;
	}



	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}

	@Column( name = "birth_date" )
	@Temporal(TemporalType.DATE)
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Transient
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Lob
	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	@Lob
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	@JoinColumn( name = "team_fk" )
	public Team getTeam() {
		return team;
	}



	public void setTeam(Team team) {
		this.team = team;
	}


	@ManyToMany
	@JoinTable( name = "t_player_skill",
		joinColumns = {@JoinColumn( name = "player_fk")},
		inverseJoinColumns = {@JoinColumn(name = "skill_fk" )},
		uniqueConstraints = @UniqueConstraint(columnNames = {"player_fk", "skill_fk"})
			)
	public List<Skill> getSkills() {
		return skills;
	}



	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}



	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", position=" + position
				+ ", number=" + number + "]";
	}

	

	
	

}

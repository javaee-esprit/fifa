package com.fifa.tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.fifa.persistence.Player;
import com.fifa.services.PlayerServiceRemote;

public class TestCreatePlayer {
	
	public static void main(String[] args) {
		
		PlayerServiceRemote proxy = null;
		Context ctx = null;
		try{
			ctx = new InitialContext();
			proxy = (PlayerServiceRemote) ctx.lookup("ejb:/fifa-ejb/PlayerService!com.fifa.services.PlayerServiceRemote");
		}catch(NamingException ex){
			ex.printStackTrace();
		}
		
		Player player = new Player();
		player.setId(2);
		player.setName("Ronaldo");
		player.setNumber(7);
		proxy.create(player);
		
	}

}

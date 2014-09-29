package com.fifa.tests;

import java.util.Iterator;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.fifa.persistence.Player;
import com.fifa.services.PlayerServiceRemote;

public class TestFindAllPlayers {
	
	public static void main(String[] args) {
		PlayerServiceRemote proxy = null;
		Context ctx = null;
		try{
			ctx = new InitialContext();
			proxy = (PlayerServiceRemote) ctx.lookup("ejb:/fifa-ejb/PlayerService!com.fifa.services.PlayerServiceRemote");
		}catch(NamingException ex){
			ex.printStackTrace();
		}
		
		List<Player> allOfThem = proxy.findAllPlayers();
		for(Player p : allOfThem){
			System.out.println(p);
		}
	}

}

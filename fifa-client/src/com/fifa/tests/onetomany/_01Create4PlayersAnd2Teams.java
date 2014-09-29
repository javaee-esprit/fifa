package com.fifa.tests.onetomany;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.fifa.persistence.Player;
import com.fifa.persistence.Team;
import com.fifa.services.PlayerServiceRemote;

public class _01Create4PlayersAnd2Teams {
	
	public static void main(String[] args) {
		
		PlayerServiceRemote proxy = null;
		Context ctx = null;
		try{
			ctx = new InitialContext();
			proxy = (PlayerServiceRemote) ctx.lookup("ejb:/fifa-ejb/PlayerService!com.fifa.services.PlayerServiceRemote");
		}catch(NamingException ex){
			ex.printStackTrace();
		}
		
		Player p1 = new Player(1, "Lampard", "midfield", 8);
		Player p2 = new Player(2, "Messi", "striker", 10);
		Player p3 = new Player(3, "Neymar", "striker", 11);
		Player p4 = new Player(4, "Costa", "striker", 19);
		
		Team t1 = new Team(1, "BARCA");
		Team t2 = new Team(2, "CHELSEA");
		
		proxy.create(p1);
		proxy.create(p2);
		proxy.create(p3);
		proxy.create(p4);
		
		proxy.create(t1);
		proxy.create(t2);
		
		
		
	}

}

package com.fifa.tests.onetomany;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.fifa.persistence.Player;
import com.fifa.persistence.Team;
import com.fifa.services.PlayerServiceRemote;

public class _03QueryFindPlayersByTeam {
	
	public static void main(String[] args) {
		PlayerServiceRemote proxy = null;
		Context ctx = null;
		try{
			ctx = new InitialContext();
			proxy = (PlayerServiceRemote) ctx.lookup("ejb:/fifa-ejb/PlayerService!com.fifa.services.PlayerServiceRemote");
		}catch(NamingException ex){
			ex.printStackTrace();
		}
		Team t1 = proxy.findTeamById(1);
		List<Player> players = proxy.findPlayersByTeam(t1);
		
		for(Player p:players)
			System.out.println(p);
	}

}

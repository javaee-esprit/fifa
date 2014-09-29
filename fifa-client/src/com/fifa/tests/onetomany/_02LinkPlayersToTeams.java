package com.fifa.tests.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.fifa.persistence.Player;
import com.fifa.persistence.Team;
import com.fifa.services.PlayerServiceRemote;

public class _02LinkPlayersToTeams {
	
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
		
		Player p2 = proxy.findPlayerById(2);
		Player p3 = proxy.findPlayerById(3);
		
//		List<Player> t1Players = new ArrayList<>();
//		t1Players.add(p2);
//		t1Players.add(p3);
//		t1.setPlayers(t1Players);
//		
//		proxy.update(t1);
		
		p2.setTeam(t1);
		proxy.update(p2);
		
		
		
		p3.setTeam(t1);
		proxy.update(p3);
		
		
		
	}

}

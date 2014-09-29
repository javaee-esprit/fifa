package com.fifa.tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.fifa.persistence.Player;
import com.fifa.services.PlayerServiceRemote;

public class TestFindPlayer {

	public static void main(String[] args) {
		PlayerServiceRemote proxy = null;
		Context ctx = null;
		try{
			ctx = new InitialContext();
			proxy = (PlayerServiceRemote) ctx.lookup("ejb:/fifa-ejb/PlayerService!com.fifa.services.PlayerServiceRemote");
		}catch(NamingException ex){
			ex.printStackTrace();
		}
		
		Player found = proxy.findPlayerById(2);
		System.out.println(found);
		System.out.println(found.getTeam());
		
	}

}

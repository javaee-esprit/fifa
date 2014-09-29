package com.fifa.tests.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.fifa.persistence.Player;
import com.fifa.persistence.Team;
import com.fifa.services.PlayerServiceRemote;

public class _05CascadePersistOperation {

	public static void main(String[] args) {

		PlayerServiceRemote proxy = null;
		Context ctx = null;
		try {
			ctx = new InitialContext();
			proxy = (PlayerServiceRemote) ctx
					.lookup("ejb:/fifa-ejb/PlayerService!com.fifa.services.PlayerServiceRemote");
		} catch (NamingException ex) {
			ex.printStackTrace();
		}

		Player p5 = new Player(5, "Pirlo", "midfield", 21);
		Player p6 = new Player(6, "Tevez", "striker", 10);

		Team t3 = new Team(3, "JUVENTUS");

		List<Player> t3Players = new ArrayList<>();
		t3Players.add(p5);
		t3Players.add(p6);

		t3.setPlayers(t3Players);

		p5.setTeam(t3);
		p6.setTeam(t3);

		proxy.create(t3);

	}

}

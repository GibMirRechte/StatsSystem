package de.juniorinjects.statssystem.listener;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import de.juniorinjects.statssystem.mysql.StatsHandler;

public class StatsListener implements Listener {
	
	StatsHandler statsHandler = new StatsHandler();
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player killer = e.getEntity().getKiller();
		Player toter = e.getEntity().getPlayer();
		
		statsHandler.registerPlayer(killer);
		statsHandler.registerPlayer(toter);
		
		int killerkills = statsHandler.getKills(killer);
		statsHandler.setKills(killer, killerkills+1);
		
		int totertote = statsHandler.getTode(toter);
		statsHandler.setTode(toter, totertote+1);
		
		int killerelo = statsHandler.getElo(killer);
		statsHandler.setElo(killer, killerelo+2);
		
		int toterelo = statsHandler.getElo(toter);
		statsHandler.setElo(toter, toterelo-1);
		
		killer.playSound(killer.getLocation(), Sound.NOTE_PLING, 2F, 3F);
		toter.playSound(toter.getLocation(), Sound.ANVIL_LAND, 2F, 3F);
		
		e.setKeepInventory(true);
		e.setDroppedExp(0);
		e.getEntity().getInventory().clear();
		e.setDeathMessage(null);
	}
}

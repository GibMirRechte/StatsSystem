package de.juniorinjects.statssystem;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import de.juniorinjects.statssystem.cmd.StatsCmd;
import de.juniorinjects.statssystem.cmd.TopCmd;
import de.juniorinjects.statssystem.listener.StatsListener;
import de.juniorinjects.statssystem.mysql.Handler;

public class Main extends JavaPlugin{
	
	Handler handler = new Handler();
	
	@Override
	public void onEnable() {
		System.out.println("thanks for using StatsSytem-1.0 by RoyalAPI");
		
		handler.connect();
		
		Bukkit.getPluginManager().registerEvents(new StatsListener(), this);
		
		getCommand("stats").setExecutor(new StatsCmd());
		getCommand("top").setExecutor(new TopCmd());
		
	}
	
	public void onDisable() {
		handler.disconnect();
	}
}

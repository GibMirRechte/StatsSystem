package de.juniorinjects.statssystem.cmd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.juniorinjects.statssystem.PluginManager;

public class TopCmd implements CommandExecutor {
	
	PluginManager plm = new PluginManager();
	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		if(s instanceof Player) {
			Player p = (Player) s;
			if(args.length == 0) {
				p.sendMessage(plm.getPrefix() + " §eTop 10:");
				//top 10 hier her
			}else
				p.sendMessage(plm.getPrefix() + " §cbitte nutze §7/top§c!");
		}
		return false;
	}

}

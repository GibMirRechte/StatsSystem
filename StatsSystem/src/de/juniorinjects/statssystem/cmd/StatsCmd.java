package de.juniorinjects.statssystem.cmd;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.juniorinjects.statssystem.PluginManager;
import de.juniorinjects.statssystem.mysql.StatsHandler;

public class StatsCmd implements CommandExecutor {
	
	StatsHandler sh = new StatsHandler();
	PluginManager plm = new PluginManager();
	
	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		if(s instanceof Player) {
			Player p = (Player) s;
			if(args.length == 0) {
				p.sendMessage(plm.getPrefix() + " §eDeine ALLTIME Stats:");
				p.sendMessage(" ");
				p.sendMessage("   §ePlatz §8× §7" + sh.getPosition(p));
				p.sendMessage("   §eKills §8× §7" + sh.getKills(p));
				p.sendMessage("   §eTode §8× §7" + sh.getTode(p));
				p.sendMessage("   §eElo §8× §7" + sh.getElo(p));
				p.sendMessage("   §eKD §8× §7soon");
				p.sendMessage(" ");
			}else if(args.length == 1) {
				p.sendMessage(plm.getPrefix() + " §e" + args[0] + "'s ALLTIME Stats:");
				
				@SuppressWarnings("deprecation")
				OfflinePlayer t = Bukkit.getOfflinePlayer(args[0]);
				
				p.sendMessage(" ");
				p.sendMessage("   §ePlatz §8× §7" + sh.getPosition((Player) t));
				p.sendMessage("   §eKills §8× §7" + sh.getKills((Player) t));
				p.sendMessage("   §eTode §8× §7" + sh.getTode((Player) t));
				p.sendMessage("   §eElo §8× §7" + sh.getElo((Player) t));
				p.sendMessage("   §eKD §8× §7soon");
				p.sendMessage(" ");
			}else
				p.sendMessage(plm.getPrefix() + " §cbitte nutze §7/stats <SPIELER>§c!");
		}
		return false;
	}
}
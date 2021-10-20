package de.juniorinjects.statssystem.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.entity.Player;

public class StatsHandler {
	
	Handler handler = new Handler();
	
	public boolean isRegistered(Player player) {
		try {
			PreparedStatement ps = handler.getConnection().prepareStatement("SELECT Kills FROM stats WHERE UUID = ?");
			ps.setString(1,  player.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			return rs.next();
		}catch (SQLException exe) {
			exe.printStackTrace();
		}
		return false;
	}
	
	public void registerPlayer(Player player) {
		if(isRegistered(player)) {
			return;
		}
		
		try {
			PreparedStatement ps = handler.getConnection().prepareStatement("INSERT INTO stats (UUID, Kills, Tode, Elo) VALUES (?,0,0,0)");
			ps.setString(1,  player.getUniqueId().toString());
			ps.execute();
		}catch (SQLException exe) {
			exe.printStackTrace();
		}
		
	}
	
	public int getKills(Player player) {
		try {
			PreparedStatement ps = handler.getConnection().prepareStatement("SELECT Kills FROM stats WHERE UUID = ?");
			ps.setString(1,  player.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt("Kills");
			}
		}catch (SQLException exe) {
			exe.printStackTrace();
		}
		return 0;
	}
	
	public void setKills(Player player, int kills) {
		try {
			PreparedStatement ps = handler.getConnection().prepareStatement("UPDATE stats SET Kills = ? WHERE UUID = ?");
			ps.setInt(1,  kills);
			ps.setString(2,  player.getUniqueId().toString());
			ps.executeUpdate();
		}catch (SQLException exe) {
			exe.printStackTrace();
		}
	}
	
	public int getTode(Player player) {
		try {
			PreparedStatement ps = handler.getConnection().prepareStatement("SELECT Deaths FROM stats WHERE UUID = ?");
			ps.setString(1,  player.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt("Deaths");
			}
		}catch (SQLException exe) {
			exe.printStackTrace();
		}
		return 0;
	}
	
	public void setTode(Player player, int tode) {
		try {
			PreparedStatement ps = handler.getConnection().prepareStatement("UPDATE stats SET Deaths = ? WHERE UUID = ?");
			ps.setInt(1,  tode);
			ps.setString(2,  player.getUniqueId().toString());
			ps.executeUpdate();
		}catch (SQLException exe) {
			exe.printStackTrace();
		}
	}
	
	public int getElo(Player player) {
		try {
			PreparedStatement ps = handler.getConnection().prepareStatement("SELECT Elo FROM stats WHERE UUID = ?");
			ps.setString(1,  player.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt("Elo");
			}
		}catch (SQLException exe) {
			exe.printStackTrace();
		}
		return 0;
	}
	
	public void setElo(Player player, int elo) {
		try {
			PreparedStatement ps = handler.getConnection().prepareStatement("UPDATE stats SET Elo = ? WHERE UUID = ?");
			ps.setInt(1,  elo);
			ps.setString(2,  player.getUniqueId().toString());
			ps.executeUpdate();
		}catch (SQLException exe) {
			exe.printStackTrace();
		}
	}
	
	public int getPosition(Player player) {
		return 0;
	}
}

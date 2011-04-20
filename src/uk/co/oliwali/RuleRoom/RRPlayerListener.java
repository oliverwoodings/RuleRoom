package uk.co.oliwali.RuleRoom;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

public class RRPlayerListener extends PlayerListener {
	
	RuleRoom plugin;
	
	public RRPlayerListener(RuleRoom instance) {
		this.plugin = instance;
	}
	
	public void onPlayerJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		Config config = plugin.config;
		if (player.getWorld().getName().equalsIgnoreCase(config.joinWorld)) {
			Location loc = new Location(player.getWorld(), config.x, config.y, config.z);
			player.teleport(loc);
			if (!config.ruleMessage.equals(""))
				plugin.sendMessage(player, config.ruleMessage);
		}
		
	}

}

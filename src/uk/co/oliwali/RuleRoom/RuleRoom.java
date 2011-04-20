package uk.co.oliwali.RuleRoom;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RuleRoom extends JavaPlugin {
	
	public String name;
	public String version;
	public Config config;
	private RRPlayerListener playerListener = new RRPlayerListener(this);
	public static final Logger log = Logger.getLogger("Minecraft");
	
	public void onDisable() {
		sendMessage("info", "Version " + version + " disabled!");
	}
	
	public void onEnable() {

		//Set up config and database
		name = this.getDescription().getName();
        version = this.getDescription().getVersion();
        config = new Config(this);
        
        // Register events
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvent(Type.PLAYER_JOIN, playerListener, Event.Priority.Monitor, this);
        sendMessage("info", "Version " + version + " enabled!");
        
	}
	
	public void sendMessage(Player player, String msg) {
		player.sendMessage(replaceColors(msg));
	}
	
	public void sendMessage(String level, String msg) {
		msg = "[" + name + "] " + msg;
		if (level == "info")
			log.info(msg);
		else
			log.severe(msg);
	}
	
    public String replaceColors(String str) {
        str = str.replace("`c", ChatColor.RED.toString());
        str = str.replace("`4", ChatColor.DARK_RED.toString());
        str = str.replace("`e", ChatColor.YELLOW.toString());
        str = str.replace("`6", ChatColor.GOLD.toString());
        str = str.replace("`a", ChatColor.GREEN.toString());
        str = str.replace("`2", ChatColor.DARK_GREEN.toString());
        str = str.replace("`b", ChatColor.AQUA.toString());
        str = str.replace("`8", ChatColor.DARK_AQUA.toString());
        str = str.replace("`9", ChatColor.BLUE.toString());
        str = str.replace("`1", ChatColor.DARK_BLUE.toString());
        str = str.replace("`d", ChatColor.LIGHT_PURPLE.toString());
        str = str.replace("`5", ChatColor.DARK_PURPLE.toString());
        str = str.replace("`0", ChatColor.BLACK.toString());
        str = str.replace("`8", ChatColor.DARK_GRAY.toString());
        str = str.replace("`7", ChatColor.GRAY.toString());
        str = str.replace("`f", ChatColor.WHITE.toString());
        return str;
    }
	
}

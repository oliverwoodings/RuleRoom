package uk.co.oliwali.RuleRoom;

import java.util.HashMap;
import java.util.List;

import org.bukkit.World;
import org.bukkit.util.config.Configuration;

public class Config {
	
	private HashMap<String, String> messages = new HashMap<String, String>();
	public RuleRoom plugin;
	private Configuration config;
	public String joinWorld;
	public double x;
	public double y;
	public double z;
	public String ruleMessage;

	public Config (RuleRoom instance) {
		
		this.plugin = instance;
		this.config = plugin.getConfiguration();
		config.load();
		
		List<String> keys = config.getKeys(null);
		
		if (!keys.contains("joinWorld"))
			config.setProperty("joinWorld", "world");
		if (!keys.contains("x"))
			config.setProperty("x", "0");
		if (!keys.contains("y"))
			config.setProperty("x", "80");
		if (!keys.contains("z"))
			config.setProperty("x", "0");
		if (!keys.contains("ruleMessage"))
			config.setProperty("ruleMessage", "`cPlease read the rules!");

		if (!config.save())
			plugin.sendMessage("severe", "Error while writing to config.yml");
		
		joinWorld = config.getString("joinWorld");
		x = config.getDouble("x", 0.0);
		y = config.getDouble("y", 80.0);
		z = config.getDouble("z", 0.0);
		ruleMessage = config.getString("ruleMessage");
		
		//Attempt save
		if (!config.save())
			plugin.sendMessage("severe", "Error while writing to config.yml");

	}
	
	public String getWorldMessage(World world) {
		return messages.get(world.getName());
	}
	
}
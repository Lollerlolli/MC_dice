package me.lollerlolli.dice.main;

import org.bukkit.plugin.java.JavaPlugin;

import me.lollerlolli.dice.commands.RollDice;

public class Main extends JavaPlugin {

	public void onEnable() {
		//executed with enable on server startup
		getCommand("rollDice").setExecutor(new RollDice());
	}
	
}

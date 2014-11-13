package me.skylertyler.skylerpgm;

import me.skylertyler.skylerpgm.match.Match;
import me.skylertyler.skylerpgm.utils.Log;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class SkylerPGM extends JavaPlugin {

	private Match match;

	private Log log;

	private static SkylerPGM plugin;

	@Override
	public void onEnable() {
		Log.infoMSG("[SkylerPGM] is Enabled!");
		loadListeners();
		loadCommands();
	}

	@Override
	public void onDisable() {
		Log.infoMSG("[SkylerPGM] is Disabled!");
	}

    //register listener
	public void registerListener(Listener listener) {
		this.getServer().getPluginManager().registerEvents(listener, this);
	}
     
    // load listeners
	public void loadListeners() {
	    //registerListener(new BlockListener(this));
	}

     // register Commands right here
	public void registerCommand(CommandExecutor executor, String name) {
		this.getCommand(name).setExecutor(executor);
	}

     //load all commands
	public void loadCommands() {
	}

	public Match getMatch() {
		return this.match;
	}

	public Log getLog() {
		return log;
	}

	public static SkylerPGM getPlugin() {
		if (plugin != null) {
			return plugin;
		} else {
			return null;
		}
	}

}

package me.skylertyler.dtw;

import java.util.logging.Level;

import me.skylertyler.dtw.commands.CycleCommand;
import me.skylertyler.dtw.commands.EndCommand;
import me.skylertyler.dtw.commands.MapListCommand;
import me.skylertyler.dtw.commands.SetnextCommand;
import me.skylertyler.dtw.commands.StartCommand;
import me.skylertyler.dtw.commands.TestCommand;
import me.skylertyler.dtw.map.Map;
import me.skylertyler.dtw.match.Match;
import me.skylertyler.dtw.utils.Log;
import me.skylertyler.dtw.utils.ServerType;

import org.bukkit.World;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class DestroyTheWool extends JavaPlugin {

	// == TIMERS :)
	// TODO fix countdowns / when every they try to do /end <time> so it won't
	// do it muliple times!

	// === COMMANDS (this week)
	// TODO add /setnext (fix setnext)
	// TODO make /cycle to /cycle (time) instead of it cycling to a diffrent
	// world without /setnext!!

	// == TEAMS
	// TODO team adding and registering
	// TODO add team color and, max ect!

	// == Holograms
	// TODO later

	// == YML DATA
	// TODO make authors in YML
	// TODO make teams in YML and basics!
	// TODO spawns!
	// TODO inventories
	// TODO regions
	// TODO teams

	public String CPREFIX = "[DTW]";
	public Match match;
	private ServerType type;
	public static DestroyTheWool plugin;

	public static DestroyTheWool getPlugin() {
		return plugin;
	}

	public void onEnable() {
		this.match = new Match(new Map(), 1);
		loadListeners();
		loadCommands();
		Log.logMessage(Level.INFO, getConsolePrefix() + " " + "is Enabled!");
	}

	public String getConsolePrefix() {
		return this.CPREFIX;

	}

	public void onDisable() {
		Log.logMessage(Level.INFO, getConsolePrefix() + " " + "is Disabled!");
	}

	public Match getMatch() {
		return this.match;
	}

	public ServerType getType() {
		return this.type;
	}

	public void setType(ServerType type) {
		this.type = type;
	}

	public void registerListener(Listener listener) {
		getServer().getPluginManager().registerEvents(listener, this);
	}

	public void registerCommand(CommandExecutor command, String label) {
		this.getCommand(label).setExecutor(command);
	}

	public void loadCommands() {
		registerCommand(new TestCommand(this), "test");
		registerCommand(new EndCommand(this), "end");
		registerCommand(new StartCommand(this), "start");
		registerCommand(new CycleCommand(this), "cycle");
		registerCommand(new SetnextCommand(this), "setnext");
		registerCommand(new MapListCommand(this), "maplist");
	}

	public void loadListeners() {

	}

	public World getCurrentWorld() {
		return this.getMatch().getCurrentMap().getWorld();
	}
}

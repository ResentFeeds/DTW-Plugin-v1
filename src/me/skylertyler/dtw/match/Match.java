package me.skylertyler.dtw.match;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import me.skylertyler.dtw.DestroyTheWool;
import me.skylertyler.dtw.map.Map;
import me.skylertyler.dtw.map.MapManager;
import me.skylertyler.dtw.timers.EndGameTimer;
import me.skylertyler.dtw.timers.StartGameTimer;

public class Match {

	private boolean hasStarted;
	private int id;
	private Map map;
	private MatchPhase phase;
	public int countdown;
	private boolean hasEnded;
	public DestroyTheWool plugin;
	public StartGameTimer timer;
	private MapManager manager = new MapManager(getPlugin());
	private Map nextMap;
	public EndGameTimer endTimer;
	private int duration;

	public Match(Map map, int id) {
		this.map = map;
		this.id = id;
		this.phase = MatchPhase.Loading;
		MapManager mapManager = this.getMapManager();
		try {
			mapManager.loadMaps();
		} catch (IOException e) {
			e.printStackTrace();
		}

		DestroyTheWool plugin = this.getPlugin();
		if (mapManager.getLoadedMaps().size() == 0) {
			plugin.getServer()
					.broadcastMessage(
							ChatColor.DARK_RED
									+ plugin.getConsolePrefix()
									+ " "
									+ ChatColor.RED
									+ "You need to have at least one map in order to run");
		}
	}

	public void startMatch() {
		Bukkit.getServer().broadcastMessage("The Match has started!");
		this.setPhase(MatchPhase.Starting);
		this.setStarted(true);
		Bukkit.getServer().getScheduler().cancelTask(getCountdown());

	}

	public void endMatch() {
		this.setPhase(MatchPhase.Ending);
		this.setEnded(true);
		Bukkit.getServer().broadcastMessage("The Match has Ended!");
		Bukkit.getServer().getScheduler()
				.cancelTask(getEndGameTimer().getRunnable());

	}

	public EndGameTimer getEndGameTimer() {
		return this.endTimer;
	}

	public MapManager getMapManager() {
		return this.manager;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setPhase(MatchPhase p) {
		this.phase = p;
	}

	public void setStarted(boolean started) {
		this.hasStarted = started;
	}

	public DestroyTheWool getPlugin() {
		return this.plugin;
	}

	public MatchPhase getPhase() {
		return this.phase;
	}

	public Map getCurrentMap() {
		return this.map;
	}

	public int getMatchID() {
		return this.id;
	}

	public int getCountdown() {
		return this.countdown;
	}

	public boolean hasEnded() {
		return hasEnded;
	}

	public boolean hasStarted() {
		return hasStarted;
	}

	public void setEnded(boolean value) {
		this.hasEnded = value;
	}

	public StartGameTimer getTimer() {
		return this.timer;
	}

	public void setNextMap(Map maps) {
		this.nextMap = map;
	}

	public Map getNextMap() {
		return this.nextMap;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setPhase(MatchPhase cycling, int duration) {
		this.phase = cycling;
		this.duration = duration;
	}
}

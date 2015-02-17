package me.skylertyler.dtw.match;

import org.bukkit.ChatColor;

public enum MatchPhase {

	Loading(ChatColor.GOLD),PreMatch(ChatColor.GRAY), Starting(ChatColor.GREEN), Playing(ChatColor.GOLD), Ending(
			ChatColor.RED), Cycling(ChatColor.AQUA);

	private ChatColor color;

	MatchPhase(ChatColor color) {
		this.color = color;
	}

	public ChatColor getColor() {
		return this.color;
	} 
}

package me.skylertyler.skylerpgm.match;

public class Match {

	private int matchid;
	private MatchPhase phase;

	public Match(int match) {
		this.matchid = match;
		this.phase = MatchPhase.PreGame;
	}

	public int getMatchID() {
		return this.matchid;
	}

	public MatchPhase getMatchPhase() {
		return this.phase;
	}

	public void setMatchPhase(MatchPhase phase) {
		this.phase = phase;
	}

}

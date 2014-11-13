import org.bukkit.ChatColor;
import org.bukkit.DyeColor;

public enum MatchPhase {

	Cycling(ChatColor.RED, "Cycling"), Playing(ChatColor.YELLOW, "Playing"), Restarting(
			ChatColor.GOLD, "Restarting"), PreGame(ChatColor.GREEN, "PreGame");

	private ChatColor color;
	private String text;
	private DyeColor Dcolor;


    MatchPhase(ChatColor color, String text) {
		this.color = color;
		this.text = text;
	}

	private MatchPhase(DyeColor Dcolor) {
		this.Dcolor = Dcolor;
	}

	public ChatColor getColor() {
		return this.color;
	}

	public String getText() {
		return this.text;
	}

	@Override
	public String toString() {
		return getColor() + getText();
	}

	public DyeColor getDyeColorFromMatchPhase() {
		switch (this) {
		case Cycling:
			return DyeColor.RED;
		case Playing:
			return DyeColor.YELLOW;
		case Restarting:
			return DyeColor.ORANGE;
		case PreGame:
			return DyeColor.GREEN;
		default:
			return DyeColor.WHITE;

		}
	}



	public DyeColor getDyeColor() {
		return this.Dcolor;
	}
}

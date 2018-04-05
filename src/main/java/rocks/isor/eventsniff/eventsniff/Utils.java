package rocks.isor.eventsniff.eventsniff;

import org.bukkit.Location;

public class Utils {


	public static String generateCoordinateString(Location location) {
		int blockX = location.getBlockX();
		int blockY = location.getBlockY();
		int blockZ = location.getBlockZ();

		return blockX + "x" + blockY + "x" + blockZ;
	}
	/*
	Regex Search & Replace Pattern to generate all the methods from a list of words

	(\t+)(\w+)(\n)

	@EventHandler
	public void on$2($2 event) {
		this.onBlockEvent(event);
	}

	*/
}

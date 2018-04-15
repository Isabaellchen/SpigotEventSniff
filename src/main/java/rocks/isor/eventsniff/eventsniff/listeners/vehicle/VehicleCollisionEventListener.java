package rocks.isor.eventsniff.eventsniff.listeners.vehicle;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleBlockCollisionEvent;
import org.bukkit.event.vehicle.VehicleCollisionEvent;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;
import rocks.isor.eventsniff.eventsniff.Utils;

public class VehicleCollisionEventListener implements Listener, CanOutputEvent {

	private boolean isVerbose;

	public VehicleCollisionEventListener(boolean isVerbose) {
		this.isVerbose = isVerbose;
	}

	private void onVehicleCollisionEvent(VehicleCollisionEvent vehicleCollisionEvent, boolean verbose) {
		Location location = vehicleCollisionEvent.getVehicle().getLocation();
		String coordinates = Utils.generateCoordinateString(location);
		String uuid = vehicleCollisionEvent.getVehicle().getUniqueId().toString();

		throttledOutput(vehicleCollisionEvent, uuid ,coordinates, isVerbose || verbose);
	}

	@EventHandler
	public void onVehicleBlockCollisionEvent(VehicleBlockCollisionEvent event) {
		this.onVehicleCollisionEvent(event, false);
	}

	@EventHandler
	public void onVehicleEntityCollisionEvent(VehicleEntityCollisionEvent event) {
		this.onVehicleCollisionEvent(event, false);
	}

}

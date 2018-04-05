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

	private void onVehicleCollisionEvent(VehicleCollisionEvent vehicleCollisionEvent) {
		Location location = vehicleCollisionEvent.getVehicle().getLocation();
		String coordinates = Utils.generateCoordinateString(location);

		output(vehicleCollisionEvent, coordinates);
	}

	@EventHandler
	public void onVehicleBlockCollisionEvent(VehicleBlockCollisionEvent event) {
		this.onVehicleCollisionEvent(event);
	}

	@EventHandler
	public void onVehicleEntityCollisionEvent(VehicleEntityCollisionEvent event) {
		this.onVehicleCollisionEvent(event);
	}

}

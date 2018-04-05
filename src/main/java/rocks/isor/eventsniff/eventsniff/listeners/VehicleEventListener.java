package rocks.isor.eventsniff.eventsniff.listeners;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleCollisionEvent;
import org.bukkit.event.vehicle.VehicleCreateEvent;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.event.vehicle.VehicleUpdateEvent;
import rocks.isor.eventsniff.eventsniff.CanBroadcastEvent;

public class VehicleEventListener implements Listener, CanBroadcastEvent {

	private void onVehicleEvent(VehicleEvent vehicleEvent) {
		Location location = vehicleEvent.getVehicle().getLocation();
		String coordinates = generateCoordinateString(location);

		broadcastEvent(vehicleEvent, coordinates);
	}

	@EventHandler
	public void onVehicleCollisionEvent(VehicleCollisionEvent event) {
		this.onVehicleEvent(event);
	}

	@EventHandler
	public void onVehicleCreateEvent(VehicleCreateEvent event) {
		this.onVehicleEvent(event);
	}

	@EventHandler
	public void onVehicleDamageEvent(VehicleDamageEvent event) {
		this.onVehicleEvent(event);
	}

	@EventHandler
	public void onVehicleDestroyEvent(VehicleDestroyEvent event) {
		this.onVehicleEvent(event);
	}

	@EventHandler
	public void onVehicleEnterEvent(VehicleEnterEvent event) {
		this.onVehicleEvent(event);
	}

	@EventHandler
	public void onVehicleExitEvent(VehicleExitEvent event) {
		this.onVehicleEvent(event);
	}

	@EventHandler
	public void onVehicleMoveEvent(VehicleMoveEvent event) {
		this.onVehicleEvent(event);
	}

	@EventHandler
	public void onVehicleUpdateEvent(VehicleUpdateEvent event) {
		this.onVehicleEvent(event);
	}
}

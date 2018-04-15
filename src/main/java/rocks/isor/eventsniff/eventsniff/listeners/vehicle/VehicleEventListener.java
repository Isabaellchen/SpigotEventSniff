package rocks.isor.eventsniff.eventsniff.listeners.vehicle;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleCreateEvent;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.event.vehicle.VehicleUpdateEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;
import rocks.isor.eventsniff.eventsniff.Utils;

public class VehicleEventListener implements Listener, CanOutputEvent {

	private boolean isVerbose;

	public VehicleEventListener(boolean isVerbose) {
		this.isVerbose = isVerbose;
	}

	private void onVehicleEvent(VehicleEvent vehicleEvent, boolean verbose) {
		Location location = vehicleEvent.getVehicle().getLocation();
		String coordinates = Utils.generateCoordinateString(location);

		output(vehicleEvent, coordinates, isVerbose || verbose);
	}

	@EventHandler
	public void onVehicleCreateEvent(VehicleCreateEvent event) {
		this.onVehicleEvent(event, false);
	}

	@EventHandler
	public void onVehicleDamageEvent(VehicleDamageEvent event) {
		this.onVehicleEvent(event, false);
	}

	@EventHandler
	public void onVehicleDestroyEvent(VehicleDestroyEvent event) {
		this.onVehicleEvent(event, false);
	}

	@EventHandler
	public void onVehicleEnterEvent(VehicleEnterEvent event) {
		this.onVehicleEvent(event, false);
	}

	@EventHandler
	public void onVehicleExitEvent(VehicleExitEvent event) {
		this.onVehicleEvent(event, false);
	}

	@EventHandler
	public void onVehicleMoveEvent(VehicleMoveEvent event) {
		this.onVehicleEvent(event, false);
	}

	@EventHandler
	public void onVehicleUpdateEvent(VehicleUpdateEvent event) {
		this.onVehicleEvent(event, false);
	}
}

package rocks.isor.eventsniff.eventsniff.listeners.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServiceEvent;
import org.bukkit.event.server.ServiceRegisterEvent;
import org.bukkit.event.server.ServiceUnregisterEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;

public class ServiceEventListener implements Listener, CanOutputEvent {

	private void onServiceEvent(ServiceEvent serviceEvent) {
		output(serviceEvent, "LOCALHOST");
	}

	@EventHandler
	public void onServiceRegisterEvent(ServiceRegisterEvent event) {
		this.onServiceEvent(event);
	}

	@EventHandler
	public void onServiceUnregisterEvent(ServiceUnregisterEvent event) {
		this.onServiceEvent(event);
	}

}

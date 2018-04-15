package rocks.isor.eventsniff.eventsniff.listeners.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServiceEvent;
import org.bukkit.event.server.ServiceRegisterEvent;
import org.bukkit.event.server.ServiceUnregisterEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;

public class ServiceEventListener implements Listener, CanOutputEvent {

	private boolean isVerbose;

	public ServiceEventListener(boolean isVerbose) {
		this.isVerbose = isVerbose;
	}

	private void onServiceEvent(ServiceEvent serviceEvent, boolean verbose) {
		output(serviceEvent, "LOCALHOST", isVerbose || verbose);
	}

	@EventHandler
	public void onServiceRegisterEvent(ServiceRegisterEvent event) {
		this.onServiceEvent(event, false);
	}

	@EventHandler
	public void onServiceUnregisterEvent(ServiceUnregisterEvent event) {
		this.onServiceEvent(event, false);
	}

}

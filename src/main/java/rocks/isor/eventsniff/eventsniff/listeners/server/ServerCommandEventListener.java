package rocks.isor.eventsniff.eventsniff.listeners.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.RemoteServerCommandEvent;
import org.bukkit.event.server.ServerCommandEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;

public class ServerCommandEventListener implements Listener, CanOutputEvent {

	@EventHandler
	public void onServerCommandEvent(ServerCommandEvent serverCommandEvent) {
		output(serverCommandEvent, "LOCALHOST");
	}

	@EventHandler
	public void onRemoteServerCommandEvent(RemoteServerCommandEvent event) {
		this.onServerCommandEvent(event);
	}

}

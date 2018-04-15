package rocks.isor.eventsniff.eventsniff.listeners.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.RemoteServerCommandEvent;
import org.bukkit.event.server.ServerCommandEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;

public class ServerCommandEventListener implements Listener, CanOutputEvent {

	private boolean isVerbose;

	public ServerCommandEventListener(boolean isVerbose) {
		this.isVerbose = isVerbose;
	}

	private void onServerCommandEvent(ServerCommandEvent serverCommandEvent, boolean verbose) {
		output(serverCommandEvent, "LOCALHOST", isVerbose || verbose);
	}

	@EventHandler
	public void onServerCommandEvent(ServerCommandEvent event) {
		this.onServerCommandEvent(event, false);
	}

	@EventHandler
	public void onRemoteServerCommandEvent(RemoteServerCommandEvent event) {
		this.onServerCommandEvent(event, false);
	}

}

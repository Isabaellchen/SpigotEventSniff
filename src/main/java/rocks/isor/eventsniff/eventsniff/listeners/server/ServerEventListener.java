package rocks.isor.eventsniff.eventsniff.listeners.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.BroadcastMessageEvent;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.event.server.ServerEvent;
import org.bukkit.event.server.ServerListPingEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;

public class ServerEventListener implements Listener, CanOutputEvent {

	private boolean isVerbose;

	public ServerEventListener(boolean isVerbose) {
		this.isVerbose = isVerbose;
	}

	private void onServerEvent(ServerEvent serverEvent, boolean verbose) {
		output(serverEvent, "LOCALHOST", isVerbose || verbose);
	}

	@EventHandler
	public void onBroadcastMessageEvent(BroadcastMessageEvent event) {
		this.onServerEvent(event, false);
	}

	@EventHandler
	public void onMapInitializeEvent(MapInitializeEvent event) {
		this.onServerEvent(event, false);
	}

	@EventHandler
	public void onServerListPingEvent(ServerListPingEvent event) {
		this.onServerEvent(event, false);
	}
}

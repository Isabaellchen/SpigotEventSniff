package rocks.isor.eventsniff.eventsniff.listeners.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.BroadcastMessageEvent;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.event.server.ServerEvent;
import org.bukkit.event.server.ServerListPingEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;

public class ServerEventListener implements Listener, CanOutputEvent {

	private void onServerEvent(ServerEvent serverEvent) {
		output(serverEvent, "LOCALHOST");
	}

	@EventHandler
	public void onBroadcastMessageEvent(BroadcastMessageEvent event) {
		this.onServerEvent(event);
	}

	@EventHandler
	public void onMapInitializeEvent(MapInitializeEvent event) {
		this.onServerEvent(event);
	}

	@EventHandler
	public void onServerListPingEvent(ServerListPingEvent event) {
		this.onServerEvent(event);
	}
}

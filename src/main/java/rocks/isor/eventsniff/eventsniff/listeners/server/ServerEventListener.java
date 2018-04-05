package rocks.isor.eventsniff.eventsniff.listeners.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.BroadcastMessageEvent;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.event.server.PluginEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.event.server.ServerEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.server.ServiceEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;

public class ServerEventListener implements Listener, CanOutputEvent {

	private void onServerEvent(ServerEvent serverEvent) {
		output(serverEvent, "LOCALHOST");
	}

	// @EventHandler -- Disabled, so we do not create a loop
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

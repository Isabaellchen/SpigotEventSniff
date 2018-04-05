package rocks.isor.eventsniff.eventsniff.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.BroadcastMessageEvent;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.event.server.PluginEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.event.server.ServerEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.server.ServiceEvent;
import rocks.isor.eventsniff.eventsniff.CanBroadcastEvent;

public class ServerEventListener implements Listener, CanBroadcastEvent {

	private void onServerEvent(ServerEvent serverEvent) {
		broadcastEvent(serverEvent, "EventSniff-LOCALHOST");
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
	public void onPluginEvent(PluginEvent event) {
		this.onServerEvent(event);
	}

	@EventHandler
	public void onServerCommandEvent(ServerCommandEvent event) {
		this.onServerEvent(event);
	}

	@EventHandler
	public void onServerListPingEvent(ServerListPingEvent event) {
		this.onServerEvent(event);
	}

	@EventHandler
	public void onServiceEvent(ServiceEvent event) {
		this.onServerEvent(event);
	}
}

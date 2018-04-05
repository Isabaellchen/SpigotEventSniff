package rocks.isor.eventsniff.eventsniff.listeners.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.event.server.PluginEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;

public class PluginEventListener implements Listener, CanOutputEvent {

	private void onPluginEvent(PluginEvent pluginEvent) {
		output(pluginEvent, "LOCALHOST");
	}

	@EventHandler
	public void onPluginDisableEvent(PluginDisableEvent event) {
		this.onPluginEvent(event);
	}

	@EventHandler
	public void onPluginEnableEvent(PluginEnableEvent event) {
		this.onPluginEvent(event);
	}

}

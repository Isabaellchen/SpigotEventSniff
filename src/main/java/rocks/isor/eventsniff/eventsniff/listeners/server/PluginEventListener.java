package rocks.isor.eventsniff.eventsniff.listeners.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.event.server.PluginEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;

public class PluginEventListener implements Listener, CanOutputEvent {

	private boolean isVerbose;

	public PluginEventListener(boolean isVerbose) {
		this.isVerbose = isVerbose;
	}

	private void onPluginEvent(PluginEvent pluginEvent, boolean verbose) {
		output(pluginEvent, "LOCALHOST", isVerbose || verbose);
	}

	@EventHandler
	public void onPluginDisableEvent(PluginDisableEvent event) {
		this.onPluginEvent(event, false);
	}

	@EventHandler
	public void onPluginEnableEvent(PluginEnableEvent event) {
		this.onPluginEvent(event, false);
	}

}

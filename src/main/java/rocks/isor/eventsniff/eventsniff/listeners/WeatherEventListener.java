package rocks.isor.eventsniff.eventsniff.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.weather.WeatherEvent;
import rocks.isor.eventsniff.eventsniff.CanOutputEvent;

public class WeatherEventListener implements Listener, CanOutputEvent {

	private boolean isVerbose;

	public WeatherEventListener(boolean isVerbose) {
		this.isVerbose = isVerbose;
	}

	private void onWeatherEvent(WeatherEvent weatherEvent, boolean verbose) {
		String worldName = weatherEvent.getWorld().getName();

		output(weatherEvent, worldName, isVerbose || verbose);
	}

	@EventHandler
	public void onLightningStrikeEvent(LightningStrikeEvent event) {
		this.onWeatherEvent(event, false);
	}

	@EventHandler
	public void onThunderChangeEvent(ThunderChangeEvent event) {
		this.onWeatherEvent(event, false);
	}

	@EventHandler
	public void onWeatherChangeEvent(WeatherChangeEvent event) {
		this.onWeatherEvent(event, false);
	}
}

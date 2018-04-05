package rocks.isor.eventsniff.eventsniff.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.weather.WeatherEvent;
import rocks.isor.eventsniff.eventsniff.CanBroadcastEvent;

public class WeatherEventListener implements Listener, CanBroadcastEvent {

	private void onWeatherEvent(WeatherEvent weatherEvent) {
		String worldName = weatherEvent.getWorld().getName();

		broadcastEvent(weatherEvent, worldName);
	}

	@EventHandler
	public void onLightningStrikeEvent(LightningStrikeEvent event) {
		this.onWeatherEvent(event);
	}

	@EventHandler
	public void onThunderChangeEvent(ThunderChangeEvent event) {
		this.onWeatherEvent(event);
	}

	@EventHandler
	public void onWeatherChangeEvent(WeatherChangeEvent event) {
		this.onWeatherEvent(event);
	}
}

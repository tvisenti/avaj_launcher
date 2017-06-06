
public class Baloon extends Aircraft implements IFlyable {
	private WeatherTower weatherTower = new WeatherTower();

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		switch (weatherTower.getWeather(this.coordinates)) {
		case "RAIN": {
			coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
					coordinates.getHeight() - 5);
			Display.addString(Display.formatStringBaloon(this, "It's rain a man!"));
			break;
		}
		case "FOG": {
			coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
					coordinates.getHeight() - 3);
			Display.addString(Display.formatStringBaloon(this, "Is it pollution or fog..?"));
			break;
		}
		case "SUN": {
			coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(),
					coordinates.getHeight() + 4);
			Display.addString(Display.formatStringBaloon(this, "Wow the view is unbeliable now!"));
			break;
		}
		case "SNOW": {
			coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(),
					coordinates.getHeight() - 15);
			Display.addString(Display.formatStringBaloon(this, "We should go down, now it's snowing.."));
			break;
		}
		}
		if (coordinates.getHeight() <= 0) {
			Display.addString(Display.formatStringBaloon(this, "exploded ..."));
			weatherTower.unregister(this);
		} else if (coordinates.getHeight() > 100)
			coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 100);
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
	}
}

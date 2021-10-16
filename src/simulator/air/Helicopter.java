package simulator.air;

import simulator.WeatherTower;

import java.util.HashMap;
import java.util.Map;

public class Helicopter extends AirCraft implements Flyable{
    private WeatherTower weatherTower;

    final private static Map<String, Coordinates> SHIFTS = new HashMap<>();
    final private static Map<String, String> PHRASES = new HashMap<>();
    static {
        SHIFTS.put("SUN", new Coordinates(10, 0, 2));
        SHIFTS.put("RAIN", new Coordinates(5, 0, 0));
        SHIFTS.put("FOG", new Coordinates(1, 0, 0));
        SHIFTS.put("SNOW", new Coordinates(0, 0, -12));

        PHRASES.put("SUN", "Let's enjoy the good weather and take some pics.");
        PHRASES.put("RAIN", "It's raining. Better watch out for lighting.");
        PHRASES.put("FOG", "It's fogging. I can't see anything.");
        PHRASES.put("SNOW", "It's snowing. We're gonna crash." );
    }

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    private String getPhrase() {
        return PHRASES.get(weatherTower.getWeather(coordinates));
    }

    private void printMessage() {
        System.out.println(this + ": " + getPhrase());
    }

    private void landingAndUnregister() {
        System.out.println(this + ": landing.");
        weatherTower.unregister(this);
        System.out.println(this + ": " + coordinates.toString());
    }

    @Override
    public void updateConditions() {
        changeAircraftCoordinates(SHIFTS.get(weatherTower.getWeather(coordinates)));
        printMessage();
        if (coordinates.getHeight() <= 0)
            landingAndUnregister();
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}

package simulator;

import simulator.air.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private static final String[] weather = new String[]{"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int index = Math.abs(coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude());
        return weather[index % 4];
    }
}

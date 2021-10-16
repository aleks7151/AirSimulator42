package simulator.air;

import java.util.HashMap;
import java.util.Map;

public abstract class AircraftFactory {
    private static final Map<String, CreatorFlyable> CREATORS_FLYABLE = new HashMap<String, CreatorFlyable>() {{
        put("Baloon", new CreatorFlyable() {
            @Override
            public Flyable createFlyable(String name, Coordinates coordinates) {
                return new Baloon(name, coordinates);
            }
        });
        put("JetPlane", new CreatorFlyable() {
            @Override
            public Flyable createFlyable(String name, Coordinates coordinates) {
                return new JetPlane(name, coordinates);
            }
        });
        put("Helicopter", new CreatorFlyable() {
            @Override
            public Flyable createFlyable(String name, Coordinates coordinates) {
                return new Helicopter(name, coordinates);
            }
        });
    }};

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        return CREATORS_FLYABLE.get(type).createFlyable(name, new Coordinates(longitude, latitude, height));
    }

    public static boolean canCreateFlyable(String type) {
        return CREATORS_FLYABLE.containsKey(type);
    }
}
package simulator.air;

import java.util.HashMap;
import java.util.Map;

public abstract class AircraftFactory {
    private static Map<String, CreatorFlyable> CREATORS_FLYABLE = new HashMap<String, CreatorFlyable>() {{
        put("Baloon", new CreatorFlyable() {
            @Override
            public Flyable createFlyable(String name, Coordinates coordinates) {
                return new Baloon();
            }
        });
        put("JetPlane", new CreatorFlyable() {
            @Override
            public Flyable createFlyable(String name, Coordinates coordinates) {
                return new JetPlane();
            }
        });
        put("Helicopter", new CreatorFlyable() {
            @Override
            public Flyable createFlyable(String name, Coordinates coordinates) {
                return new Helicopter();
            }
        });
    }};

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        if (CREATORS_FLYABLE.containsKey(type))
            return CREATORS_FLYABLE.get(type).createFlyable(name, new Coordinates(longitude, latitude, height));
        throw new RuntimeException("No such class (" + type + ").");
    }

    public static boolean canCreateType(String type) {
        return CREATORS_FLYABLE.containsKey(type);
    }
}
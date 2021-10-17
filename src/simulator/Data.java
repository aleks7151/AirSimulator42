package simulator;

import simulator.air.AircraftFactory;

import java.util.HashSet;
import java.util.Set;

public class Data {
    private final String name;
    private final String type;
    private final int longitude;
    private final int latitude;
    private final int height;
    private static Set<String> setNames = new HashSet<>();

    public Data(String line) {
        String[] args = line.split("\\s+");
        if (args.length != 5)
            throw new CustomValidationException("Wrong count of arguments. Problem line: " + line + ".");
        type = args[0];
        if (!AircraftFactory.canCreateFlyable(type))
            throw new CustomValidationException("Wrong type of aircraft. Problem line: " + line + ".");
        name = args[1];
        if (setNames.contains(name))
            throw new CustomValidationException("Two identical id. Line - " + line + ".");
        setNames.add(name);
        longitude = Integer.parseInt(args[2]);
        latitude = Integer.parseInt(args[3]);
        height = Integer.parseInt(args[4]);
        if (longitude < 0 || latitude < 0 || height < 0)
            throw new CustomValidationException("Coordinates must be positive numbers. Problem line: " + line + ".");
        if (height >= 100)
            throw new CustomValidationException("Height must be less than 100. Problem line: " + line + ".");
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }
}

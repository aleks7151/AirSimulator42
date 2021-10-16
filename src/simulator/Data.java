package simulator;

import simulator.air.AircraftFactory;

public class Data {
    private String name;
    private String type;
    private int longitude;
    private int latitude;
    private int height;

    public Data(String line) {
        String[] args = line.split("\\s+");
        if (args.length != 5)
            throw new CustomValidationException("Error in line: " + line + ". Wrong count of arguments. Current arguments - " + args.length + ".");
        type = args[0];
        if (!AircraftFactory.canCreateType(type)) {
            throw new CustomValidationException("Error in line: " + line + ". Wrong type of aircraft");
        }
        name = args[1];
        longitude = Integer.parseInt(args[2]);
        latitude = Integer.parseInt(args[3]);
        height = Integer.parseInt(args[4]);
        if (longitude < 0 || latitude < 0 || height < 0) {
            throw new CustomValidationException("Error in line: " + line + ". Coordinates must be positive numbers");
        }
        if (height >= 100) {
            throw new CustomValidationException("Error in line: " + line + ". Height must be less than 100");
        }
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

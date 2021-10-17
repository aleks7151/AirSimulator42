package simulator.air;

public class Coordinates {
    private final int longitude;
    private final int latitude;
    private final int height;

    Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
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

    @Override
    public String toString() {
        return "longitude=" + longitude +
                ", latitude=" + latitude +
                ", height=" + height;
    }
}

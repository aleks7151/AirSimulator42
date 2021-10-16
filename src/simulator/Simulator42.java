package simulator;

import simulator.air.AircraftFactory;
import simulator.air.Flyable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Simulator42 {
    public static void main(String[] args) {
        //https://github.com/ssoraka/avaj-launcher/tree/master/src/main/java/ex
        //https://projects.intra.42.fr/uploads/document/document/2600/avaj_uml.png
        //https://cdn.intra.42.fr/pdf/pdf/16891/en.subject.pdf
        //https://projects.intra.42.fr/uploads/document/document/2601/scenario.txt
        if (args.length != 1)
            throw new ArgumentException("The number of arguments must be one. The number of arguments is " + args.length + ".");
        PrimaryData primaryData = new PrimaryData(args[0]);
        WeatherTower weatherTower = new WeatherTower();

        PrintStream printStreamOriginal = System.out;
        try (PrintStream printStreamFile = new PrintStream(new FileOutputStream("simulation.txt"))) {
            System.setOut(printStreamFile);

            for (Data data : primaryData.getData()) {
                Flyable flyable = AircraftFactory.newAircraft(data.getType(), data.getName(), data.getLongitude(),
                        data.getLatitude(), data.getHeight());
                flyable.registerTower(weatherTower);
            }
            for (int i = 0; i < primaryData.getCount(); i++)
                weatherTower.changeWeather();

            System.setOut(printStreamOriginal);
        } catch (FileNotFoundException e) {
            System.setOut(printStreamOriginal);
            e.printStackTrace();
        }
    }
}

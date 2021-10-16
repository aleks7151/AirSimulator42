package simulator;

import simulator.air.Flyable;

import java.util.ArrayList;
import java.util.List;

public abstract class Tower {
    private final List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable){
        observers.add(flyable);
        System.out.println("Tower says: " + flyable.toString() + " registered to weather tower.");
    }

    public void unregister(Flyable flyable){
        observers.remove(flyable);
        System.out.println("Tower says: " + flyable.toString() + " unregistered to weather tower.");
    }

    protected void conditionsChanged() {
        for (Flyable f : new ArrayList<>(observers))
            f.updateConditions();
    }
}

import java.util.ArrayList;
import java.util.List;




// Abstract component for status reporting
abstract class Component {
    abstract String getStatus();
}

class Engine extends Component {
    private boolean isRunning = false; 

    public void start() {
        this.isRunning = true;
        System.out.println("   [Engine] Combustion sequence initiated.");
    }

    public void stop() {
        this.isRunning = false;
        System.out.println("   [Engine] Fuel cut off. Engine stopped.");
    }

    @Override
    String getStatus() {
        return isRunning ? "Engine: RUNNING" : "Engine: OFF";
    }
}

class BrakingSystem extends Component {
    public void apply() {
        System.out.println("   [Brakes] Hydraulic pressure applied to wheels.");
    }

    @Override
    String getStatus() {
        return "Brakes: FUNCTIONAL";
    }
}

// INTERACTION: Ignition interacts with Engine
class Ignition {
    private Engine engine;

    public Ignition(Engine engine) {
        this.engine = engine;
    }

    public void turnKey() {
        System.out.println("   [Ignition] Sending electrical signal to starter...");
        engine.start();
    }
}


// 2. VEHICLE HIERARCHY (Inheritance & Polymorphism)


abstract class Vehicle {
    protected String modelName;
    protected List<Component> components = new ArrayList<>();

    public Vehicle(String modelName) {
        this.modelName = modelName;
    }

    // Abstract methods for POLYMORPHISM
    public abstract void run();
    public abstract void stop();

    public void showStatus() {
        System.out.println("--- " + modelName + " Status Report ---");
        for (Component c : components) {
            System.out.println(c.getStatus());
        }
    }
}

class Car extends Vehicle {
    private Engine engine;
    private Ignition ignition;
    private BrakingSystem brakes;

    public Car(String modelName) {
        super(modelName);
        // COMPOSITION: Car "has-a" Engine, Ignition, and Brakes
        this.engine = new Engine();
        this.ignition = new Ignition(this.engine);
        this.brakes = new BrakingSystem();
        
        components.add(engine);
        components.add(brakes);
    }

    @Override
    public void run() {
        System.out.println("\nDriving Car: " + modelName);
        ignition.turnKey();
        System.out.println("   Car is now cruising on 4 wheels.");
    }

    @Override
    public void stop() {
        brakes.apply();
        engine.stop();
        System.out.println("   Car has come to a full stop.");
    }
}

class Bicycle extends Vehicle {
    public Bicycle(String modelName) {
        super(modelName);
    }

    @Override
    public void run() {
        System.out.println("\nOperating Bicycle: " + modelName);
        System.out.println("   Pedaling manually. No fuel required.");
    }

    @Override
    public void stop() {
        System.out.println("   Applying manual rim brakes. Stopped.");
    }
}





class VehicleFactory {
    // Factory method to produce different types
    public static Vehicle produceVehicle(String type, String model) {
        if (type.equalsIgnoreCase("CAR")) {
            System.out.println("FACTORY: Assembling a new Car...");
            return new Car(model);
        } else if (type.equalsIgnoreCase("CYCLE")) {
            System.out.println("FACTORY: Assembling a new Bicycle...");
            return new Bicycle(model);
        }
        throw new IllegalArgumentException("Unknown vehicle type.");
    }
}




public class ProductionLine {
    public static void main(String[] args) {
        // Use factory to create objects
        Vehicle myCar = VehicleFactory.produceVehicle("CAR", "Sedan-X");
        Vehicle myBike = VehicleFactory.produceVehicle("CYCLE", "Mountain-Pro");

        // Polymorphic behavior
        myCar.run();
        myCar.showStatus();
        myCar.stop();

        myBike.run();
        System.out.println("checking status of bike");
        myBike.showStatus();
        myBike.stop();
    }
}

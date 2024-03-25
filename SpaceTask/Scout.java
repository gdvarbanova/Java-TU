package space;
import java.util.Random;

public class Scout {
    protected double speed; 
    protected double sensorRange;
    private Resource resource;

    public Scout(double speed, double sensorRange){
        this.speed = speed;
        this.sensorRange = sensorRange;
        resource = null;
    }

    public void explore(){
        System.out.println("Scout is exploring the area...");
        if (resource == null) {
            System.out.println("No resource discovered yet.");
            resource = new Resource("New Resource", 100, 1.0); 
            System.out.println("Resource discovered: " + resource.getName());
        } else {
            System.out.println("Discovered resource: " + resource.getName());
        }
        Random random = new Random();
        int numberOfObjectsFound = random.nextInt(10);
        
        for (int i = 1; i < numberOfObjectsFound; i++) {
            int objectType = random.nextInt(4);
            
            if (objectType == 1) {
                System.out.println("Scout found a planet.");
            } else if (objectType == 2) {
                System.out.println("Scout found an asteroid.");
            } else {
                System.out.println("Scout found a star system.");
            }
        }
        System.out.println("Exploration completed.");
    }
    
    public void reportResources(Planet planet){
        if (resource != null) {
            System.out.println("Scout is reporting discovered resources:");
            System.out.println("Resource Type: " + planet.metal.getName());
            System.out.println("Amount: " + planet.metal.getAmount());
            System.out.println("Resource Type: " + planet.gas.getName());
            System.out.println("Amount: " + planet.gas.getAmount());
            System.out.println("Resource Type: " + planet.crystal.getName());
            System.out.println("Amount: " + planet.crystal.getAmount());
            System.out.println("Resource Type: " + planet.uranium.getName());
            System.out.println("Amount: " + planet.uranium.getAmount());
        System.out.println("Resources reported.");
        } else {
            System.out.println("No resources to report.");
        }
    }
}
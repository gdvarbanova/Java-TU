package space;

public class Main {
    public static void main(String[] args) {
        // Create a planet
        Planet earth = new Planet("Earth", 0.0, 0.0, 0.0, 5.972e24, new Resource("Metal", 1000, 1.0), new Resource("Gas", 500, 0.5), new Resource("Crystal", 200, 0.2), new Resource("Uranium", 100, 0.1));

        // Create a satellite
        Satellite moon = new Satellite("Moon", 384400, 0.0, 0.0, 7.342e22);

        // Add the satellite to orbit around the planet

        earth.addOrbiter(moon);
        earth.addOrbiter(earth);

        // Create a scout
        Scout scout = new Scout(100, 200);

        // Scout explores the area
        scout.explore();

        // Report discovered resources
        scout.reportResources(earth);

        // Create a star
        Star sun = new Star("Sun", 0.0, 0.0, 0.0, 1.989e30);

        // Orbit the planet around the star
        try {
            earth.orbit(sun);
        } catch (NotValidSpaceObjectException e) {
            System.err.println(e.getMessage());
        }
    }
}

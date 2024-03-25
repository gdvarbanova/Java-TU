package space;

public abstract class SpaceObject {
    protected String name;
    protected double coordinateX;
    protected double coordinateY;
    protected double coordinateZ;
    protected double mass;

    public SpaceObject(String name, double coordinateX, double coordinateY, double coordinateZ, double mass){
        this.name = name;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.coordinateZ = coordinateZ;
        this.mass = mass;
    }

    public void displayInfo(){
        System.out.println("Name: " + name + "\nx: " + coordinateX + "\ny: " + coordinateY + "\nz: " + coordinateZ + "\nMass: " + mass);
    }
}
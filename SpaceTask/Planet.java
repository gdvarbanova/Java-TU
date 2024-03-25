package space;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Planet extends OrbitableSpaceObject implements Orbiter {
    protected Resource metal; 
    protected Resource gas; 
    protected Resource crystal; 
    protected Resource uranium;
    protected List<BaseBuilding> buildings;

    public Planet(String name, double coordinateX, double coordinateY, double coordinateZ, double mass, Resource metal, Resource gas, Resource crystal, Resource uranium){
        super(name, coordinateX, coordinateY, coordinateZ, mass);
        metal = new Resource("metal", 0, 1.0);
        gas = new Resource("gas", 0, 0.5);
        crystal = new Resource("crystal", 0, 0.2);
        uranium = new Resource("uranium", 0, 0.1);
        this.buildings = new ArrayList<>();

    }

    public void orbit(SpaceObject target) throws NotValidSpaceObjectException {
        if(target instanceof Star){
            System.out.println("Planet " + name + " orbits around " + target.name);
        }
        else throw new NotValidSpaceObjectException("Invalid object to orbit around!");
    }

    public void harvestMetal() {
        metal.harvest();
    }

    public void harvestGas() {
        gas.harvest();
    }

    public void harvestCrystal() {
        crystal.harvest();
    }

    public void harvestUranium() {
        uranium.harvest();
    }

    public void printResources(){
        System.out.println("Metal: " + metal.getAmount());
        System.out.println("Gas: " + gas.getAmount());
        System.out.println("Crystal: " + crystal.getAmount());
        System.out.println("Uranium: " + uranium.getAmount());
    }

    public void addBuilding(BaseBuilding building){
        buildings.add(building);
    }

    public List<BaseBuilding> getBuildings(){
        return buildings;
    }

    /*public void construct(Planet target){
        System.out.print("Enter building to construct: ");
        Scanner input 
    }*/
}
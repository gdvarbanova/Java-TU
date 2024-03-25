package space;

import java.util.List;
import java.util.ArrayList;

public abstract class OrbitableSpaceObject extends SpaceObject{
    protected List<SpaceObject> orbiters;
    public OrbitableSpaceObject(String name, double coordinateX, double coordinateY, double coordinateZ, double mass){
        super(name, coordinateX, coordinateY, coordinateZ, mass);
        this.orbiters = new ArrayList<>();
    }

    public void addOrbiter(SpaceObject orbiter){
        orbiters.add(orbiter);
    }

    public List<SpaceObject> getOrbiters(){
        return orbiters;
    }
}
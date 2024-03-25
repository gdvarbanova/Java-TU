package space;

public class Satellite extends OrbitableSpaceObject {
    public Satellite(String name, double coordinateX, double coordinateY, double coordinateZ, double mass){
        super(name, coordinateX, coordinateY, coordinateZ, mass);
    }

    public void orbit(SpaceObject target) throws NotValidSpaceObjectException {
        if(target instanceof Planet){
            System.out.println("Satellite " + name + " orbits around " + target.name);
        }
        else throw new NotValidSpaceObjectException("Invalid object to orbit around!");
    }
}
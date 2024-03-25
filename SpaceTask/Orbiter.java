package space;

public interface Orbiter {
    void orbit(SpaceObject target) throws NotValidSpaceObjectException;
}
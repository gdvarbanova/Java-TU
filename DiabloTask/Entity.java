package diablo;

import java.util.Objects;

public abstract class Entity {
    protected String name;
    public Entity(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Entity entity)) return false;
        return Objects.equals(getName(), entity.getName());
    }

    @Override
    public int hashCode(){
        return Objects.hash(getName());
    }
}

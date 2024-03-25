package space;

public class SpaceShip {
    protected String type; 
    protected double speed; 
    protected double cargoCapacity; 
    protected double weaponPower;
    protected int damage;
    protected int life;

    public SpaceShip(String type, double speed, double cargoCapacity, double weaponPower, int damage, int life){
        this.type = type;
        this.speed = speed;
        this.cargoCapacity = cargoCapacity;
        this.weaponPower = weaponPower;
        this.damage = damage;
        this.life = life;
    }

    public void travel(){
        System.out.println("Spaceship is travelling!");
    }

    /*public void harvestResource(){

    }*/

    public void attack(SpaceShip target){
        target.life -= this.damage;
    }

    public boolean isWrecked(){
        if(this.life <=0) return true;
        else return false;
    }
}
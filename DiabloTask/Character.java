package diablo;

import java.util.*;

public class Character extends Entity implements Attacker, Damageable {
    protected int health;
    protected double damage;
    protected int level;
    protected List<Item> items;

    public Character(int health, double damage, int level, String name){
        super(name);
        this.health = health;
        this.damage = damage;
        this.level = level;
        this.items = new ArrayList<>();
    }

    @Override
    public void receiveDamage(Character target) {
        target.health -= this.damage;
        System.out.println(this.name + " attacked " + target.name + " and they got " + this.damage + " damage.");
        if(target.health <= 0){
            System.out.println(target.name + " is not alive!");
        }
    }

    @Override
    public void attack(Character target) {
        receiveDamage(target);
    }
   
    public void levelUp(){
        this.level ++;
        System.out.println("Level " + this.level + " unlocked!");
    }
}

package diablo;

public class Monster extends Entity implements Attacker, Damageable {
    protected int health;
    protected double damage;

    public Monster(int health, double damage, int level, String name){
        super(name);
        this.health = health;
        this.damage = damage;
    }

    @Override
    public void receiveDamage(Character target) {
        target.health -= this.damage;
        System.out.println(this.name + " attacked " + target.name + " and they got " + this.damage + " damage.");
    }

    @Override
    public void attack(Character target) {
        receiveDamage(target);
    }
}

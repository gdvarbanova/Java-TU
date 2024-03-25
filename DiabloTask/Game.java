package diablo;

import java.util.HashSet;
import java.util.LinkedList;

public class Game {
    HashSet<Monster> monsters = new HashSet<>();
    HashSet<Character> characters = new HashSet<>();
    LinkedList<Item> items = new LinkedList<>();

    public void addCharacter(Character character){
        characters.add(character);
    }

    public void removeCharacter(Character character){
        characters.remove(character);
    }

    public void addMonster(Monster monster){
        monsters.add(monster);
    }

    public void removeMonster(Monster monster){
        monsters.remove(monster);
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public void collectItem(Character character, Item item){
        character.items.add(item);
        item.attributeBoost = "boosted";
    }

    public void attackCharacter(Monster attacker, Character target){
        attacker.receiveDamage(target);
    }

    public void attackEvil(Character attacker, Monster target){
        target.health -= attacker.damage;
        System.out.println(attacker.name + " attacked " + target.name + " and they got " + attacker.damage + " damage.");
        if(target.health <= 0){
            System.out.println(target.name + " is not alive!");
        }
        attacker.levelUp();
    }

    public void applyAttributeBoost(Character character, Item item){
        if(item.attributeBoost.equals("boosted")){
            character.damage += 1;
        }
        else{
            System.out.println("No boost available!");
        }
    }

    public void displayGameState(){
        System.out.println();
    }

}

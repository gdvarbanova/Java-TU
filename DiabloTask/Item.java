package diablo;

public class Item extends Entity{
    protected String attributeBoost;

    public Item(String attributeBoost, String name){
        super(name);
        this.attributeBoost = attributeBoost;
    }
}

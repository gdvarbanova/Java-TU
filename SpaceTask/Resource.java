package space;

public class Resource {
    protected String name;
    protected double amount;
    protected double harvestRate;

    public Resource(String name, double amount, double harvestRate){
        this.name = name;
        this.amount = amount;
        this.harvestRate = harvestRate;
    }

    protected double getAmount() {
        return this.amount;
    }

    protected String getName(){
        return name;
    }

    protected double getHarvestRate(){
        return this.harvestRate;
    }

    public void harvest() {
        amount += harvestRate; 
    }
}
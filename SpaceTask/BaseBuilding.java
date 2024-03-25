package space;

public class BaseBuilding {
    protected String name;
    protected int level;
    protected int constructionTime;
    protected double metalRequired;
    protected double crystalRequired;
    protected double gasRequired;
    protected double uraniumRequired;

    BaseBuilding(String name, int level, int constructionTime, double metalRequired, double crystalRequired, double gasRequired, double uraniumRequired){
        this.name = name;
        this.level = level;
        this.constructionTime = constructionTime;
        this.metalRequired = metalRequired;
        this.crystalRequired = crystalRequired;
        this.gasRequired = gasRequired;
        this.gasRequired = gasRequired;
    }

    /*void construct(Planet target);
    void upgrade();
    void applyEffect();*/
}
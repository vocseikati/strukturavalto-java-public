package pokebag;

public abstract class Pokemon {

    protected int health = 10;
    protected int strength;
    protected String name;

    abstract String speak();

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "health=" + health +
                ", strength=" + strength +
                ", name='" + name + '\'' +
                '}';
    }
}

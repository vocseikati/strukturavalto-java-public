package hu.nive.ujratervezes.zarovizsga.aquarium;

public abstract class Fish {

    protected String name;
    protected Integer weight;
    protected String color;
    protected boolean hasMemoryLoss = false;

    public Fish(String name, Integer weight, String color) {
        this.name = name;
        this.weight = weight;
        this.color = color;
    }

    public String status() {
        return name + ", weight: " + weight + ", color: " + color
                + ", short term memory loss: " + hasMemoryLoss;
    }

    public abstract void feed();

    public String getName() {
        return name;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public boolean hasMemoryLoss() {
        return hasMemoryLoss;
    }
}

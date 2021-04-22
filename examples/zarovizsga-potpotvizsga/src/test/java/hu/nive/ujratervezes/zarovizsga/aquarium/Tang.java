package hu.nive.ujratervezes.zarovizsga.aquarium;

public class Tang extends Fish{

    public Tang(String name, Integer weight, String color) {
        super(name, weight, color);
        hasMemoryLoss = true;
    }

    public void feed() {
        weight++;
    }
}

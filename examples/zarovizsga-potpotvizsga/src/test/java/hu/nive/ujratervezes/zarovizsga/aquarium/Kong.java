package hu.nive.ujratervezes.zarovizsga.aquarium;

public class Kong extends Fish{

    public Kong(String name, Integer weight, String color) {
        super(name, weight, color);
    }

    public void feed() {
        weight += 2;
    }
}

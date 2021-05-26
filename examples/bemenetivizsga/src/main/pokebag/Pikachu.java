package pokebag;

public class Pikachu extends Pokemon {

    public Pikachu() {
        this.name = "Pikachu";
        this.strength = 10;
    }

    public Pikachu(String name) {
        this.name = name;
        this.strength = 10;
    }

    @Override
    String speak() {
        return "Pika-pika";
    }
}

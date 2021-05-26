package pokebag;

public class Charmander extends Pokemon {

    public Charmander() {
        this.strength = 8;
        this.name = "Charmander";
    }

    public Charmander(String name) {
        this.strength = 8;
        this.name = name;
    }

    @Override
    String speak() {
        return "Char-char";
    }
}

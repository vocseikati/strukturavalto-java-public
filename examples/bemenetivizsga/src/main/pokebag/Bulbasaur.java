package pokebag;

public class Bulbasaur extends Pokemon {

    public Bulbasaur() {
        this.strength = 6;
        this.name = "Bulbasaur";
    }

    public Bulbasaur(String name){
        this.name = name;
        this.strength = 6;
    }

    @Override
    String speak() {
        return "Bulba-saur";
    }
}

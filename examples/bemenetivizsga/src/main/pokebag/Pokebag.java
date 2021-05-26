package pokebag;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Pokebag {

    private List<Pokemon> pokemons = new ArrayList<>();


    public void add(Pokemon pokemon) {
        if (pokemon == null){
            throw new IllegalArgumentException();
        }
        pokemons.add(pokemon);
    }

    public int getNumberOfPokemons() {
        return pokemons.size();
    }

    public Pokemon getStrongest() {
        return pokemons.stream().max(Comparator.comparingInt(o -> o.strength)).orElseThrow(NoSuchElementException::new);
    }

    public Pokemon getByIndex(int i) {
        return pokemons.get(i);
    }

    public Pokemon fight(int i, int j) {
        if (i == j){
            throw new IllegalArgumentException();
        }
        Pokemon pokemon1 = getByIndex(i);
        Pokemon pokemon2 = getByIndex(j);
        if (pokemon1.strength != pokemon2.strength){
            int maxStrength = Math.max(pokemon1.strength, pokemon2.strength);
            if (pokemon1.strength == maxStrength){
                pokemon2.health -= 1;
                System.out.println(pokemon1.speak());
                return pokemon1;
            }else {
                pokemon1.health -= 1;
                System.out.println(pokemon2.speak());
                return pokemon2;
            }
        }
        pokemon2.health -= 1;
        System.out.println(pokemon1.speak());
        return pokemon1;
    }
}

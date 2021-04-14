package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {

    List<Dog> dogs = new ArrayList<>();

    public List<Dog> getDogs() {
        return dogs;
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void feedAll() {
        for (Dog dog : dogs) {
            dog.feed();
        }
    }

    public Dog findByName(String name) {
        boolean found = false;
        for (Dog dog : dogs) {
            if (dog.getName().equals(name)){
                found = true;
                return dog;
            }
        }
        throw new IllegalArgumentException();
    }

    public void playWith(String name, int hours) {
        findByName(name).play(hours);
    }

    public List<String> getHappyDogNames(int minHappiness) {
        List<String> happyDogs = new ArrayList<>();

        for (Dog dog : dogs) {
            if (dog.happiness > minHappiness){
                happyDogs.add(dog.getName());
            }
        }
        return happyDogs;
    }
}

package hu.nive.ujratervezes.zarovizsga.aquarium;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aquarium {

    private List<Fish> fish = new ArrayList<>();

    public List<String> getStatus() {
        List<String> status = new ArrayList<>();
        for (Fish f : fish) {
            status.add(f.status());
        }
        return status;
    }

    public void addFish(Fish f) {
        Objects.requireNonNull(f);
        fish.add(f);
    }

    public void removeFish() {
        fish.removeIf(f -> f.weight > 10);
        //List<Fish> fatFish = new ArrayList<>();
        //        for (Fish fish : pod) {
        //            if (fish.getWeight() >= 11) {
        //                fatFish.add(fish);
        //            }
        //        }
        //        pod.removeAll(fatFish);
    }

    public void feed() {
        for (Fish f : fish) {
            f.feed();
        }
    }
}

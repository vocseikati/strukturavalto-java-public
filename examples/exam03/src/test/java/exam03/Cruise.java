package exam03;

import java.time.LocalDate;
import java.util.*;

public class Cruise {

    Boat boat;
    LocalDate sailing;
    double basicPrice;
    List<Passenger> passengers = new ArrayList<>();

    public Cruise(Boat boat, LocalDate sailing, double basicPrice) {
        this.boat = boat;
        this.sailing = sailing;
        this.basicPrice = basicPrice;
    }

    public Boat getBoat() {
        return boat;
    }

    public LocalDate getSailing() {
        return sailing;
    }

    public double getBasicPrice() {
        return basicPrice;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void bookPassenger(Passenger passenger) {
        if (boat.maxPassengers <= passengers.size()) {
            throw new IllegalArgumentException("nincs elég hely");
        }
        passengers.add(passenger);
    }


    public double getPriceForPassenger(Passenger name) {
        double price = 0;
        if (name.cruiseClass.equals(CruiseClass.LUXURY)) {
            price = this.basicPrice * 3.0;
        }
        if (name.cruiseClass.equals(CruiseClass.FIRST)) {
            price = this.basicPrice * 1.8;
        }
        if (name.cruiseClass.equals(CruiseClass.SECOND)) {
            price = this.basicPrice;
        }
        return price;
    }

    public Passenger findPassengerByName(String name) {
        for (Passenger passenger : passengers) {
            if (passenger.name.equals(name)) {
                return passenger;
            }
        }
        return null;
    }

    public List<String> getPassengerNamesOrdered() {
        List<String> names = new ArrayList<>();
        passengers.sort(Comparator.comparing(Passenger::getName));
        for (Passenger passenger : passengers) {
            names.add(passenger.getName());
        }
        return names;
    }

    public double sumAllBookingsCharged() {
        double sum = 0;
        for (Passenger passenger : passengers) {
            sum += getPriceForPassenger(passenger);
        }
        return sum;
    }

    public Map<CruiseClass, Integer> countPassengerByClass() {
        Map<CruiseClass, Integer> result = new HashMap<>();
        for (Passenger passenger : passengers) {
            if (result.containsKey(passenger.cruiseClass)) {
                result.put(passenger.cruiseClass, result.get(passenger.cruiseClass) + 1);
            }else {
                result.put(passenger.cruiseClass, 1);
            }
        }
        return result;
    }
}

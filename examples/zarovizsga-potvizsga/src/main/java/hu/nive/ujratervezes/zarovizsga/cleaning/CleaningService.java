package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.List;

public class CleaningService {

    private List<Cleanable> cleanables;

    public CleaningService() {
        this.cleanables = new ArrayList<>();
    }

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public List<Cleanable> getCleanables() {
        return cleanables;
    }

    public int cleanAll() {
        int sum = 0;
        for (Cleanable cleanable : cleanables) {
            sum += cleanable.clean();
        }
        cleanables.removeAll(cleanables);
        return sum;
    }

    public int cleanOnlyOffices() {
        int sum = 0;
        List<Cleanable> trash = new ArrayList<>();
        for (Cleanable cleanable : cleanables) {
            if (cleanable instanceof Office) {
                sum += cleanable.clean();
                trash.add(cleanable);
            }
        }
        cleanables.removeAll(trash);
        return sum;
    }

    public List<Cleanable> findByAddressPart(String address) {
        List<Cleanable> result = new ArrayList<>();
        for (Cleanable cleanable : cleanables) {
            if (cleanable.getAddress().contains(address)) {
                result.add(cleanable);
            }
        }
        return result;
    }

    public String getAddresses() {
        StringBuilder sb = new StringBuilder();

        if (cleanables.size() == 0) {
            return sb.toString(); //""
        }

        for (int i = 0; i < cleanables.size() - 1; i++) {
            sb.append(cleanables.get(i).getAddress());
            sb.append(", ");
        }
        int index = (cleanables.size() - 1);
        sb.append(cleanables.get(index).getAddress());
//
//        StringBuilder sb = new StringBuilder();
//        sb.append(cleanables.get(0).getAddress());
//
//        for (int i = 1; i < cleanables.size(); i++) {
//            sb.append(", ").append(cleanables.get(i).getAddress());
//        }
//        return sb.toString();

//        String prefix = "";
//        for (Cleanable cleanable : cleanables) {
//            sb.append(prefix);
//            prefix = ", ";
//            sb.append(cleanable.getAddress());
//        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "CleaningService{" +
                "cleanables=" + cleanables +
                '}';
    }

    public static void main(String[] args) {
        CleaningService service = new CleaningService();
        service.add(new House("Bp. Fo ut 1.", 130));
        service.add(new House("Bp. Fo ut 2.", 300));
        service.add(new Office("Bp. Fo ut 3.", 300, 3));
        service.add(new Office("Bp. Fo ut 4.", 300, 4));
        System.out.println(service);
        StringBuilder sb = new StringBuilder();

        List<Cleanable> cleanables = service.getCleanables();
        for (int i = 0; i < cleanables.size() - 1; i++) {
            sb.append(cleanables.get(i).getAddress()).append(", ");
        }
        String address = cleanables.get(cleanables.size() - 1).getAddress();
        sb.append(address);
        System.out.println(sb.toString());
    }
}

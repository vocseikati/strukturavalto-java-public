package CanoeRental;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CanoeOffice {

    private List<CanoeRental> canoes = new ArrayList<>();

    public List<CanoeRental> getCanoes() {
        return canoes;
    }

    public void addRental(CanoeRental canoe){
        Objects.requireNonNull(canoe);
        canoes.add(canoe);
    }
}

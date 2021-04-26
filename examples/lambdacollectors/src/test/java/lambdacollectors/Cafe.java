package lambdacollectors;

import org.junit.jupiter.api.Order;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cafe {

    private List<CoffeeOrder> orders;

    public Cafe(List<CoffeeOrder> orders) {
        this.orders = orders;
    }

    public Map<CoffeeType, Long> getCountByCoffeeType() {
        return orders.stream()
                .flatMap(order -> order.getCoffeeList().stream())
                .collect(Collectors.groupingBy(Coffee::getType, Collectors.counting()));
    }

    public double getAverageOrder() {
        return orders.stream()
                .collect(Collectors.averagingDouble(order -> order.getCoffeeList().size()));
    }
}

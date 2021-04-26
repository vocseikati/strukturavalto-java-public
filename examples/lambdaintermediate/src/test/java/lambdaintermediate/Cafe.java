package lambdaintermediate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cafe {

    private List<CoffeeOrder> orders;

    public Cafe(List<CoffeeOrder> orders) {
        this.orders = orders;
    }

    public long getNumberOfCoffee(CoffeeType type) {
        return orders.stream()
                .flatMap(order -> order.getCoffeeList().stream())
                .filter(coffee -> coffee.getCoffeeType().equals(type))
                .count();
        //long sum = 0;
        //        for (CoffeeOrder order : orders) {
        //            for (Coffee coffee : order.getCoffeeList()) {
        //                if (coffee.getCoffeeType().equals(type)){
        //                    sum ++;
        //                }
        //            }
        //        }
        //        return sum;
    }

    public BigDecimal getTotalIncome() {
        double totalIncome = orders.stream()
                .flatMap(order -> order.getCoffeeList().stream())
                .mapToDouble(coffee -> coffee.getPrice().doubleValue())
                .sum();
        return BigDecimal.valueOf(totalIncome).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotalIncome(LocalDate date) {
        double totalIncomeByDate = orders.stream()
                .filter(coffeeOrder -> coffeeOrder.getDateTime().toLocalDate().equals(date))
                .flatMap(order -> order.getCoffeeList().stream())
                .mapToDouble(coffee -> coffee.getPrice().doubleValue())
                .sum();
        return BigDecimal.valueOf(totalIncomeByDate).setScale(2, RoundingMode.HALF_UP);
    }

    public List<CoffeeOrder> getOrdersAfter(LocalDateTime from) {
        return orders.stream()
                .filter(order -> order.getDateTime().isAfter(from))
                .collect(Collectors.toList());
        //List<CoffeeOrder> ordersFromDate = new ArrayList<>();
        //        for (CoffeeOrder order : orders) {
        //            if (order.getDateTime().isAfter(from)){
        //                ordersFromDate.add(order);
        //            }
        //        }
    }

    public List<CoffeeOrder> getFirstFiveOrder(LocalDate date) {
        return orders.stream()
                .filter(coffeeOrder -> coffeeOrder.getDateTime().toLocalDate().equals(date))
                .sorted(Comparator.comparing(CoffeeOrder::getDateTime))
                .limit(5)
                .collect(Collectors.toList());

    }
}

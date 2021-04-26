package lambdaintermediate;

import java.math.BigDecimal;

public class Coffee {

    private CoffeeType coffeeType;
    private BigDecimal price;

    public Coffee(CoffeeType coffeeType, BigDecimal price) {
        this.coffeeType = coffeeType;
        this.price = price;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

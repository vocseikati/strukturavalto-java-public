package lambdaprimitives;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class SportGadgetStore {

    private List<Product> products;

    public SportGadgetStore(List<Product> products) {
        this.products = products;
    }

    public int getNumberOfProducts() {
        return products.stream().mapToInt(Product::getPieces).sum();
    }

    public double getAveragePrice() {
        return products.stream().mapToDouble(Product::getPrice).average().orElse(0);
    }

    public String getExpensiveProductStatistics(double minPrice) {
        IntSummaryStatistics pieceStat = products.stream()
                .filter(product -> product.getPrice() > minPrice)
                .mapToInt(Product::getPieces)
                .summaryStatistics();
        if (pieceStat.getCount() > 0) {
            return "Összesen " + pieceStat.getCount() + " féle termék, " +
                    "amelyekből minimum " + pieceStat.getMin() + " db, maximum " +
                    pieceStat.getMax() + " db, összesen " + pieceStat.getSum() + " db van.";
        }
        return "Nincs ilyen termék.";
    }
}

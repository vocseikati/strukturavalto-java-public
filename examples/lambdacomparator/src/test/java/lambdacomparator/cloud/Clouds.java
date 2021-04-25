package lambdacomparator.cloud;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Clouds {


    public CloudStorage alphabeticallyFirst(List<CloudStorage> storages) {
        return storages.stream()
                .min((o1, o2) -> o1.getProvider()
                        .compareToIgnoreCase(o2.getProvider())).orElse(null);
//        return Collections.min(storages, Comparator.comparing(CloudStorage::getProvider, String::compareToIgnoreCase));

        //storages.stream().sorted(new Comparator<CloudStorage>() {
        //            @Override
        //            public int compare(CloudStorage o1, CloudStorage o2) {
        //                return o1.getProvider().compareToIgnoreCase(o2.getProvider());
        //            }
        //        });

    }

    public CloudStorage bestPriceForShortestPeriod(List<CloudStorage> storages) {
        return storages.stream().min(Comparator.comparing(CloudStorage::getPeriod, Comparator.nullsFirst(Comparator.comparingInt(PayPeriod::getLength)))
                .thenComparingDouble(CloudStorage::getPrice)).orElse(null);
        //return Collections.min(storages, Comparator.comparing(CloudStorage::getPeriod, Comparator.nullsFirst(Comparator.comparingInt(PayPeriod::getLength))).thenComparingDouble(CloudStorage::getPrice));
    }

    public List<CloudStorage> worstOffers(List<CloudStorage> storages) {
        return storages.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
    }
}

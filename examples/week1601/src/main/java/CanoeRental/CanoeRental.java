package CanoeRental;

import java.time.Duration;
import java.time.LocalDateTime;

public class CanoeRental {

    private String name;
    private CanoeType canoeType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public CanoeRental(String name, CanoeType canoeType, LocalDateTime startTime) {
        this.name = name;
        this.canoeType = canoeType;
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public double calculateRentalSum() {
        double price = 0;
        if (endTime != null) {
            long hours = Duration.between(startTime, endTime).toHours();
            if (canoeType.equals(CanoeType.RED)) {
                price = 5000 * hours;
            }
            if (canoeType.equals(CanoeType.GREEN)){
                price = 5000 * 1.2 * hours;
            }
            if (canoeType.equals(CanoeType.BLUE)){
                price = 5000 * 1.5 * hours;
            }
        }
        return price;
    }

    public String getName() {
        return name;
    }

    public CanoeType getCanoeType() {
        return canoeType;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}

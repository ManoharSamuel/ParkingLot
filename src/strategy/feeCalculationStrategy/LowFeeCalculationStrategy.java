package strategy.feeCalculationStrategy;

import models.Ticket;
import models.VehicleType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LowFeeCalculationStrategy implements FeeCalculationStrategy{
    private static final int FEE_PER_MINUTE_TWO_WHEELERS = 2;
    private static final int FEE_PER_MINUTE_FOUR_WHEELERS = 4;

    @Override
    public long getFeeAmount(Ticket ticket) {
        long timeSpentInMinutes = ChronoUnit.MINUTES.between(LocalDateTime.now(), ticket.getEntryTime());
        if (ticket.getVehicle().getVehicleType().equals(VehicleType.Four_Wheeler)) {
            return FEE_PER_MINUTE_FOUR_WHEELERS * timeSpentInMinutes;
        } else {
            return FEE_PER_MINUTE_TWO_WHEELERS * timeSpentInMinutes;
        }

    }
}

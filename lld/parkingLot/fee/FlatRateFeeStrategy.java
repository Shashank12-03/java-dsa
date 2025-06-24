package lld.parkingLot.fee;

import lld.parkingLot.Ticket;

public class FlatRateFeeStrategy implements FeeStrategy {
    private static final double RATE_PER_HOUR = 10.0;

    @Override
    public double calculateFee(Ticket ticket){
        long duration  = ticket.getExitTime() - ticket.getExitTime();
        long hours = (duration/(100*60*60))+1;
        return hours*RATE_PER_HOUR;
    }
}

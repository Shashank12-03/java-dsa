package lld.parkingLot.fee;

import lld.parkingLot.Ticket;

public interface FeeStrategy {
    double calculateFee(Ticket ticket);
} 

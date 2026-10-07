package library;

public class SimpleFineCalculator implements FineCalculator {
    private static final double FINE_PER_DAY = 5.0;   // Static member

    @Override
    public double calculateFine(int daysLate) {
        if (daysLate <= 0) return 0;
        return daysLate * FINE_PER_DAY;
    }
}
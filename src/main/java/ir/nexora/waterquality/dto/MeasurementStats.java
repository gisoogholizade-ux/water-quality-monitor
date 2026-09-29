package ir.nexora.waterquality.dto;

public record MeasurementStats(
        long count,
        double averagePh,
        double averageTemperature,
        double averageDissolvedOxygen,
        double averageConductivity,
        double minPh,
        double maxPh
) {}

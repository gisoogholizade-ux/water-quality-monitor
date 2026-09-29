package ir.nexora.waterquality.repository;

import ir.nexora.waterquality.model.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    List<Measurement> findTop10ByOrderByMeasuredAtDesc();
    List<Measurement> findAllByOrderByMeasuredAtDesc();
    List<Measurement> findByLocationContainingIgnoreCaseOrderByMeasuredAtDesc(String location);
    List<Measurement> findByMeasuredAtBetweenOrderByMeasuredAtDesc(LocalDateTime from, LocalDateTime to);
    List<Measurement> findByLocationContainingIgnoreCaseAndMeasuredAtBetweenOrderByMeasuredAtDesc(String location, LocalDateTime from, LocalDateTime to);
}

package ir.nexora.waterquality.service;

import ir.nexora.waterquality.dto.MeasurementStats;
import ir.nexora.waterquality.model.Measurement;
import ir.nexora.waterquality.repository.MeasurementRepository;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MeasurementServiceTests {
    @Test
    void calculatesStatistics(){
        MeasurementRepository repo=mock(MeasurementRepository.class);
        MeasurementService service=new MeasurementService(repo);
        Measurement a=sample(7.0,20,6,500);
        Measurement b=sample(8.0,24,8,700);
        MeasurementStats s=service.statistics(List.of(a,b));
        assertEquals(2,s.count());
        assertEquals(7.5,s.averagePh(),0.001);
        assertEquals(22,s.averageTemperature(),0.001);
        assertEquals(7,s.averageDissolvedOxygen(),0.001);
        assertEquals(600,s.averageConductivity(),0.001);
    }

    private Measurement sample(double ph,double t,double d,double e){
        Measurement m=new Measurement();
        m.setPh(ph);m.setTemperature(t);m.setDissolvedOxygen(d);m.setConductivity(e);
        m.setLocation("Lab");m.setMeasuredAt(LocalDateTime.now());
        return m;
    }
}

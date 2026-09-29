package ir.nexora.waterquality.service;

import ir.nexora.waterquality.model.Measurement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WaterQualityAssessmentServiceTests {
    private final WaterQualityAssessmentService service = new WaterQualityAssessmentService();

    @Test
    void normalSampleHasNoWarnings(){
        Measurement m=sample(7.2,7.0,600.0);
        assertFalse(service.hasWarning(m));
    }

    @Test
    void detectsReferenceRangeWarnings(){
        Measurement m=sample(5.8,3.5,1900.0);
        assertTrue(service.hasWarning(m));
        assertEquals(3, service.warnings(m).size());
    }

    private Measurement sample(double ph,double dissolvedOxygen,double conductivity){
        Measurement m=new Measurement();
        m.setPh(ph);m.setTemperature(22.0);m.setDissolvedOxygen(dissolvedOxygen);
        m.setConductivity(conductivity);m.setLocation("Test");
        return m;
    }
}

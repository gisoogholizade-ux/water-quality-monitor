package ir.nexora.waterquality.service;

import ir.nexora.waterquality.model.Measurement;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class WaterQualityAssessmentService {
    public List<String> warnings(Measurement m){
        List<String> warnings=new ArrayList<>();
        // Prototype configurable reference ranges; not a regulatory determination.
        if(m.getPh()!=null && (m.getPh()<6.5 || m.getPh()>8.5)) warnings.add("pH خارج از محدوده مرجع نمونه (6.5 تا 8.5)");
        if(m.getDissolvedOxygen()!=null && m.getDissolvedOxygen()<5) warnings.add("اکسیژن محلول کمتر از مقدار مرجع نمونه (5 mg/L)");
        if(m.getConductivity()!=null && m.getConductivity()>1500) warnings.add("هدایت الکتریکی بیشتر از مقدار مرجع نمونه (1500 µS/cm)");
        return warnings;
    }
    public boolean hasWarning(Measurement m){return !warnings(m).isEmpty();}
}

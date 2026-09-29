package ir.nexora.waterquality.service;

import ir.nexora.waterquality.model.Measurement;
import ir.nexora.waterquality.repository.MeasurementRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MeasurementService {
    private final MeasurementRepository repository;
    public MeasurementService(MeasurementRepository repository){this.repository=repository;}
    public Measurement save(Measurement measurement){return repository.save(measurement);}
    public List<Measurement> latest(){return repository.findTop10ByOrderByMeasuredAtDesc();}
    public long count(){return repository.count();}
}

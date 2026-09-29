package ir.nexora.waterquality.service;

import ir.nexora.waterquality.dto.MeasurementStats;
import ir.nexora.waterquality.model.Measurement;
import ir.nexora.waterquality.repository.MeasurementRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class MeasurementService {
    private final MeasurementRepository repository;
    public MeasurementService(MeasurementRepository repository){this.repository=repository;}
    public Measurement save(Measurement measurement){return repository.save(measurement);}
    public List<Measurement> latest(){return repository.findTop10ByOrderByMeasuredAtDesc();}
    public long count(){return repository.count();}
    public void delete(Long id){repository.deleteById(id);}

    public List<Measurement> search(String location, LocalDateTime from, LocalDateTime to){
        boolean hasLocation = location != null && !location.isBlank();
        if(from != null && to != null && from.isAfter(to)){LocalDateTime temp=from;from=to;to=temp;}
        if(hasLocation && from != null && to != null) return repository.findByLocationContainingIgnoreCaseAndMeasuredAtBetweenOrderByMeasuredAtDesc(location.trim(),from,to);
        if(from != null || to != null){
            LocalDateTime start=from!=null?from:LocalDateTime.of(1970,1,1,0,0);
            LocalDateTime end=to!=null?to:LocalDateTime.now().plusYears(100);
            return hasLocation?repository.findByLocationContainingIgnoreCaseAndMeasuredAtBetweenOrderByMeasuredAtDesc(location.trim(),start,end):repository.findByMeasuredAtBetweenOrderByMeasuredAtDesc(start,end);
        }
        if(hasLocation) return repository.findByLocationContainingIgnoreCaseOrderByMeasuredAtDesc(location.trim());
        return repository.findAllByOrderByMeasuredAtDesc();
    }

    public List<Measurement> allChronological(){
        return repository.findAll().stream().sorted(Comparator.comparing(Measurement::getMeasuredAt)).toList();
    }

    public MeasurementStats statistics(List<Measurement> list){
        if(list.isEmpty()) return new MeasurementStats(0,0,0,0,0,0,0);
        return new MeasurementStats(list.size(),
            list.stream().mapToDouble(Measurement::getPh).average().orElse(0),
            list.stream().mapToDouble(Measurement::getTemperature).average().orElse(0),
            list.stream().mapToDouble(Measurement::getDissolvedOxygen).average().orElse(0),
            list.stream().mapToDouble(Measurement::getConductivity).average().orElse(0),
            list.stream().mapToDouble(Measurement::getPh).min().orElse(0),
            list.stream().mapToDouble(Measurement::getPh).max().orElse(0));
    }
}

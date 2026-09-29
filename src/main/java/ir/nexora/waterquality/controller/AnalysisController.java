package ir.nexora.waterquality.controller;

import ir.nexora.waterquality.model.Measurement;
import ir.nexora.waterquality.service.MeasurementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class AnalysisController {
    private final MeasurementService service;
    public AnalysisController(MeasurementService service){this.service=service;}

    @GetMapping("/analysis")
    public String analysis(Model model){
        List<Measurement> measurements = service.allChronological();
        model.addAttribute("measurements", measurements);
        model.addAttribute("stats", service.statistics(measurements));
        return "analysis";
    }
}

package ir.nexora.waterquality.controller;

import ir.nexora.waterquality.model.Measurement;
import ir.nexora.waterquality.service.MeasurementService;
import ir.nexora.waterquality.service.WaterQualityAssessmentService;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class ReportController {
    private final MeasurementService service;
    private final WaterQualityAssessmentService assessment;
    public ReportController(MeasurementService service, WaterQualityAssessmentService assessment){this.service=service;this.assessment=assessment;}

    @GetMapping("/alerts")
    public String alerts(Model model){
        List<Measurement> all=service.allChronological();
        model.addAttribute("measurements", all.stream().filter(assessment::hasWarning).toList());
        model.addAttribute("assessment", assessment);
        return "alerts";
    }

    @GetMapping("/reports/csv")
    public ResponseEntity<byte[]> csv(){
        StringBuilder b=new StringBuilder("﻿id,date,location,pH,temperature,DO,EC,notes\n");
        for(Measurement m:service.allChronological()){
            b.append(m.getId()).append(',').append(m.getMeasuredAt()).append(',').append(q(m.getLocation())).append(',')
             .append(m.getPh()).append(',').append(m.getTemperature()).append(',').append(m.getDissolvedOxygen()).append(',')
             .append(m.getConductivity()).append(',').append(q(m.getNotes())).append('\n');
        }
        HttpHeaders h=new HttpHeaders();
        h.setContentType(new MediaType("text","csv",StandardCharsets.UTF_8));
        h.setContentDisposition(ContentDisposition.attachment().filename("water-quality-report.csv").build());
        return new ResponseEntity<>(b.toString().getBytes(StandardCharsets.UTF_8),h,HttpStatus.OK);
    }
    private String q(String s){return """+(s==null?"":s.replace(""",""""))+""";}
}

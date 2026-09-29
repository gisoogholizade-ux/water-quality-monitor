package ir.nexora.waterquality.controller;

import ir.nexora.waterquality.model.Measurement;
import ir.nexora.waterquality.service.MeasurementService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class DashboardController {
    private final MeasurementService service;
    public DashboardController(MeasurementService service){this.service=service;}

    @GetMapping("/")
    public String dashboard(Model model){
        model.addAttribute("measurements", service.latest());
        model.addAttribute("count", service.count());
        return "dashboard";
    }

    @GetMapping("/measurements/new")
    public String form(Model model){
        model.addAttribute("measurement", new Measurement());
        return "measurements/form";
    }

    @PostMapping("/measurements")
    public String save(@Valid @ModelAttribute Measurement measurement, BindingResult result){
        if(result.hasErrors()) return "measurements/form";
        service.save(measurement);
        return "redirect:/";
    }
}

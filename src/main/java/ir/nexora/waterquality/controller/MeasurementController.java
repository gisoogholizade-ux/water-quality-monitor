package ir.nexora.waterquality.controller;

import ir.nexora.waterquality.service.MeasurementService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/measurements")
public class MeasurementController {
    private final MeasurementService service;
    public MeasurementController(MeasurementService service){this.service=service;}

    @GetMapping
    public String history(@RequestParam(required=false) String location,
                          @RequestParam(required=false) @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
                          @RequestParam(required=false) @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) LocalDateTime to,
                          Model model){
        model.addAttribute("measurements", service.search(location, from, to));
        model.addAttribute("location", location);
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        return "measurements/history";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "redirect:/measurements";
    }
}

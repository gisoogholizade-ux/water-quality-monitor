package ir.nexora.waterquality.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "measurements")
public class Measurement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @DecimalMin("0.0") @DecimalMax("14.0")
    private Double ph;

    @NotNull
    private Double temperature;

    @NotNull @PositiveOrZero
    private Double dissolvedOxygen;

    @NotNull @PositiveOrZero
    private Double conductivity;

    @NotBlank
    private String location;

    @NotNull
    private LocalDateTime measuredAt = LocalDateTime.now();

    @Column(length = 1000)
    private String notes;

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public Double getPh(){return ph;}
    public void setPh(Double ph){this.ph=ph;}
    public Double getTemperature(){return temperature;}
    public void setTemperature(Double temperature){this.temperature=temperature;}
    public Double getDissolvedOxygen(){return dissolvedOxygen;}
    public void setDissolvedOxygen(Double dissolvedOxygen){this.dissolvedOxygen=dissolvedOxygen;}
    public Double getConductivity(){return conductivity;}
    public void setConductivity(Double conductivity){this.conductivity=conductivity;}
    public String getLocation(){return location;}
    public void setLocation(String location){this.location=location;}
    public LocalDateTime getMeasuredAt(){return measuredAt;}
    public void setMeasuredAt(LocalDateTime measuredAt){this.measuredAt=measuredAt;}
    public String getNotes(){return notes;}
    public void setNotes(String notes){this.notes=notes;}
}

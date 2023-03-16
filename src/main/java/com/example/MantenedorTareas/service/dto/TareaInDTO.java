package com.example.MantenedorTareas.service.dto;

import com.example.MantenedorTareas.persistence.entities.TareaStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TareaInDTO {
    private String title;
    private String description;
    private LocalDateTime dateFinish;
}

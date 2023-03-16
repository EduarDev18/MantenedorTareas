package com.example.MantenedorTareas.persistence.entities;


import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "tarea")
public class Tareas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime dateFinish;
    private Boolean finished;
    private TareaStatus tareaStatus;


}

package com.example.MantenedorTareas.mapper;

import com.example.MantenedorTareas.persistence.entities.TareaStatus;
import com.example.MantenedorTareas.persistence.entities.Tareas;
import com.example.MantenedorTareas.service.dto.TareaInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class TareaInDTOToTarea implements IMapper<TareaInDTO, Tareas>{


    @Override
    public Tareas mapearDatosDeTarea(TareaInDTO in) {
        Tareas tarea=new Tareas();
        tarea.setTitle(in.getTitle());
        tarea.setDescription(in.getDescription());
        tarea.setDateFinish(in.getDateFinish());;
        tarea.setCreatedDate(LocalDateTime.now());
        tarea.setTareaStatus(TareaStatus.ON_TIME);
        tarea.setFinished(false);;
        return tarea;
    }
}

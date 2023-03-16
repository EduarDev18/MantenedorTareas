package com.example.MantenedorTareas.service;


import com.example.MantenedorTareas.exceptions.ToDoExceptions;
import com.example.MantenedorTareas.mapper.TareaInDTOToTarea;
import com.example.MantenedorTareas.persistence.entities.TareaStatus;
import com.example.MantenedorTareas.persistence.entities.Tareas;
import com.example.MantenedorTareas.persistence.repository.TareasRepository;
import com.example.MantenedorTareas.service.dto.TareaInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class TareasService {

    private final TareasRepository mtareaRepo;
    private final TareaInDTOToTarea mapper;

    public TareasService(TareasRepository mtareaRepo, TareaInDTOToTarea mapper) {
        this.mtareaRepo = mtareaRepo;
        this.mapper = mapper;
    }

    public Tareas crearTarea(TareaInDTO p_tareaDTO) {
        Tareas tarea = mapper.mapearDatosDeTarea(p_tareaDTO);
        this.mtareaRepo.save(tarea);
        return tarea;
    }

    public List<Tareas> listarTareas() {
        return this.mtareaRepo.findAll();
    }

    public List<Tareas> buscarTareasxEstados(TareaStatus p_estado) {
        return this.mtareaRepo.findAllByTareaStatus(p_estado);
    }

    @Transactional
    public void updateTareaAsFinished(Long id) {
        Optional<Tareas> tarea = this.mtareaRepo.findById(id);
        if (tarea.isEmpty()) {
            throw new ToDoExceptions("Tarea Not Found", HttpStatus.NOT_FOUND);
        }
        this.mtareaRepo.markTareasAsFinished(id);
        ;
    }


    public void eliminarTarea(Long id) {
        Optional<Tareas> tarea = this.mtareaRepo.findById(id);
        if (tarea.isEmpty()) {
            throw new ToDoExceptions("Tarea Not Found", HttpStatus.NOT_FOUND);
        }
        this.mtareaRepo.deleteById(id);
        ;
    }
}

package com.example.MantenedorTareas.controller;


import com.example.MantenedorTareas.persistence.entities.TareaStatus;
import com.example.MantenedorTareas.persistence.entities.Tareas;
import com.example.MantenedorTareas.service.TareasService;
import com.example.MantenedorTareas.service.dto.TareaInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
 @RequestMapping("/tareas/v1")
public class TaskController {

 private final TareasService tareaService;

 public TaskController(TareasService tareaService) {
  this.tareaService = tareaService;
 }

 @PostMapping
 public Tareas crearTarea(@RequestBody TareaInDTO p_tareaInDTO){
    return  this.tareaService.crearTarea(p_tareaInDTO);
 }

 @GetMapping
 public List<Tareas> obtenerTareas(){
      return this.tareaService.listarTareas();
 }


 @GetMapping("/status/{status}")
 public List<Tareas> obtenerTareasxEstado(@PathVariable("status") TareaStatus status){
  return this.tareaService.buscarTareasxEstados(status);
  }

  @PatchMapping("/mark_as_finished/{id}")
 public ResponseEntity<Void> updateTareaAsFinished     ( @PathVariable("id") Long id){
     this.tareaService.updateTareaAsFinished(id);;
          return ResponseEntity.noContent().build();
  }




  @DeleteMapping("/eliminarTarea/{id}")
 public ResponseEntity<Void> eliminarTareaController   ( @PathVariable("id") Long id){
   this.tareaService.eliminarTarea(id);;
   return ResponseEntity.noContent().build();
  }

}

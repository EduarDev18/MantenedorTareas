package com.example.MantenedorTareas.persistence.repository;

import com.example.MantenedorTareas.persistence.entities.TareaStatus;
import com.example.MantenedorTareas.persistence.entities.Tareas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TareasRepository extends JpaRepository<Tareas,Long> {

    public List<Tareas> findAllByTareaStatus(TareaStatus estados) ;

        @Modifying
        @Query(value= "UPDATE tarea SET FINISHED=true WHERE ID=:id",nativeQuery = true )
        public void markTareasAsFinished(@Param("id") Long id);




}

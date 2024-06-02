/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.udistrital.SpeedDating.controladores;

import com.udistrital.SpeedDating.modelos.Cita;
import com.udistrital.SpeedDating.repositorios.CitaRepository;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cesar
 */
@RestController
public class CitaController {

    CitaRepository database;

    public CitaController(CitaRepository bd) {
        this.database = bd;
    }//

    @GetMapping("/api/crearCitas")
    public void crearCitas() {
        Cita cita1 = new Cita(LocalDateTime.of(2022, 5, 1, 0, 0), "126", "1312");
        Cita cita2 = new Cita(LocalDateTime.of(2022, 6, 1, 2, 3), "3214", "4214");

        database.save(cita1);
        database.save(cita2);
        
    }

    @GetMapping("/api/citas")
    public List<Cita> obtenerCitas() {
        return database.findAll();
    }

    @GetMapping("/api/citas/{id}")
    public ResponseEntity<Cita> obtenerCitaById(@PathVariable Long id) {
        Optional<Cita> optional = database.findById(id);

        if (optional.isEmpty()) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(optional.get());
        }

    }
    
    //@CrossOrigin("http://127.0.0.1/PUERTOFRONTEND")
    @PostMapping("/api/citas")
    public ResponseEntity<Cita> guardarCita(@RequestBody Cita cita){
        if (cita.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        
        database.save(cita);
        return ResponseEntity.ok(cita);
    }
    
    //@CrossOrigin("http://127.0.0.1/PUERTOFRONTEND")
    @PutMapping("/api/citas")
    public ResponseEntity<Cita> actualizarCita(@RequestBody Cita cita){
        if (cita.getId() == null || !database.existsById(cita.getId())) {
            return ResponseEntity.badRequest().build();
        }
        
        database.save(cita);
        return ResponseEntity.ok(cita);
    }
    
    //@CrossOrigin("http://127.0.0.1/PUERTOFRONTEND")
    @DeleteMapping("/api/citas")
    public ResponseEntity<Cita> eliminarCita(@RequestBody Cita cita){
        if (cita.getId() == null || !database.existsById(cita.getId())) {
            return ResponseEntity.badRequest().build();
        }
        
        database.delete(cita);
        return ResponseEntity.noContent().build();
    }
    
}

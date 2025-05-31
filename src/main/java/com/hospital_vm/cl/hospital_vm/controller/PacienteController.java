package com.hospital_vm.cl.hospital_vm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_vm.cl.hospital_vm.model.Paciente;
import com.hospital_vm.cl.hospital_vm.service.PacienteService;



@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> listar(){ //ResponseEntity es una clase que representa HTTP completa, incluyendo el cuerpo, el estado y los encabezados.
        //En este caso se utiliza para devolver una lista de objetos de Paciente como cuerpo de la respuesta HTTP.      
        List<Paciente> pacientes = pacienteService.findAll(); //Especifica el tipo del cuerpo de la respuesta, que en este caso es una lista de objetos Paciente.
        if (pacientes.isEmpty()){
            return ResponseEntity.noContent().build(); //
        }
        return ResponseEntity.ok(pacientes);
    }

    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Paciente paciente) {
        try{
            Paciente productoNuevo = pacienteService.save(paciente);
            return ResponseEntity.status(HttpStatus.CREATED).body(productoNuevo);
        } catch (Exception e){
            return ResponseEntity.ok("No se pudo agregar el paciente en la base de datos"); 
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id){
        try{
            Paciente paciente = pacienteService.findById(id);
            return ResponseEntity.ok(paciente);
        } catch (Exception e){
            return ResponseEntity.ok("Paciente no encontrado"); 
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Integer id, @RequestBody Paciente paciente){
        try {
            Paciente pac = pacienteService.findById(id);
            pac.setId(id);
            pac.setRun(paciente.getRun());
            pac.setNombre(paciente.getNombre());
            pac.setApellido(paciente.getApellido());
            pac.setFechaNacimiento(paciente.getFechaNacimiento());
            pac.setCorreo(paciente.getCorreo());

            pacienteService.save(pac);
            return ResponseEntity.ok(paciente);
        } catch (Exception e){
            return ResponseEntity.ok("Paciente no encontrado"); 
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        boolean existe = pacienteService.existePorId(id);

        if (existe) {
            pacienteService.delete(id);
            return ResponseEntity.ok("Paciente eliminado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente no encontrado");
        }
    }
    
    
}

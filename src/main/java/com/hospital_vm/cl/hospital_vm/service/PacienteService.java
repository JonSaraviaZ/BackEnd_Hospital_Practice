package com.hospital_vm.cl.hospital_vm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital_vm.cl.hospital_vm.model.Paciente;
import com.hospital_vm.cl.hospital_vm.repository.PacienteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional // indica que todos los métodos de esta clase deben ejecutarse dentro de una transacción.
//Esto significa que si cualquier método de esta clase falla, la transacción se revertirá (rollback), asegurando la consistencia de los datos.
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> findAll(){
        return pacienteRepository.findAll();
    }

    public Paciente findById(long id){
        return pacienteRepository.findById(id).get();
    }

    public Paciente save(Paciente paciente){ //la funci´pn save funciona tanto para crear o actualizar
        return pacienteRepository.save(paciente);
    }

    public void delete(Long id){
        pacienteRepository.deleteById(id);
    }

    public boolean existePorId(Long id) {
        return pacienteRepository.existsById(id);
    }

    
}

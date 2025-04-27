package com.pdm12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdm12.entity.Propietario;
import com.pdm12.exceptions.PropietarioNotFoundException;
import com.pdm12.repository.PropietarioRepository;

@Service
public class PropietarioService {

	@Autowired
    private PropietarioRepository propietarioRepo;

    public Propietario getById(Long id) {
        return propietarioRepo.findById(id)
                .orElseThrow(() -> new PropietarioNotFoundException());
    }
    
    //En propietario solo uso el getById porque en este ejercicio en concreto se quiere hacer endpoints
    //sobre todo para las mascotas, si se quisieran hacer para propietarios se pondrian aqui
}

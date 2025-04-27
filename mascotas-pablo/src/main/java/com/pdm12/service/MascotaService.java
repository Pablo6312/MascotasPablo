package com.pdm12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pdm12.entity.Mascota;
import com.pdm12.entity.Propietario;
import com.pdm12.exceptions.MascotaNotFoundException;
import com.pdm12.exceptions.PropietarioNotFoundException;
import com.pdm12.repository.MascotasRepository;
import com.pdm12.repository.PropietarioRepository;

@Service
public class MascotaService {
	
	@Autowired
	private MascotasRepository mascotaRepo;
	
	@Autowired
	private PropietarioRepository propietarioRepo;
	
	
	public Mascota getById(Long id) {
		return mascotaRepo.findById(id)
				.orElseThrow(() -> new MascotaNotFoundException());
	}
	
	public Mascota save(Mascota mascota) {
		return mascotaRepo.save(mascota);
	}
	
	public List<Mascota> getAll() {
        return mascotaRepo.findAll();
    }

    public List<Mascota> getByRaza(String raza) {
        return mascotaRepo.findByRaza(raza);
    }

    public List<Mascota> getTop20Youngest() {
        return mascotaRepo.findTop20ByOrderByFechaNacDesc();
    }

    public List<Mascota> getMascotasByPage(int page) {
        Pageable pageable = PageRequest.of(page, 5);
        return mascotaRepo.findAll(pageable).getContent();
    }

    public void deleteById(Long id) {
        Mascota mascota = mascotaRepo.findById(id)
                .orElseThrow(() -> new MascotaNotFoundException());
        mascotaRepo.deleteById(mascota.getId());
    }

    public List<Mascota> getByPropietario(Long propietarioId) {
        Propietario propietario = propietarioRepo.findById(propietarioId)
                .orElseThrow(() -> new PropietarioNotFoundException());
        return mascotaRepo.findByPropietario(propietario);
    }

    public Propietario getPropietarioByMascota(Long mascotaId) {
        Mascota mascota = mascotaRepo.findById(mascotaId)
                .orElseThrow(() -> new PropietarioNotFoundException());
        return mascota.getPropietario();
    }

}

package com.pdm12.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdm12.entity.Mascota;
import com.pdm12.entity.Propietario;

@Repository
public interface MascotasRepository extends JpaRepository<Mascota, Long>{

	List<Mascota> findByRaza(String raza);
	List<Mascota> findTop20ByOrderByFechaNacDesc();
	Page<Mascota> findAll(Pageable pageable);
	List<Mascota> findByPropietario(Propietario propietario);
	
}

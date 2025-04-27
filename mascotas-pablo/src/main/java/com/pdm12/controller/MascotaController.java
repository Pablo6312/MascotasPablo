package com.pdm12.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdm12.entity.Mascota;
import com.pdm12.entity.Propietario;
import com.pdm12.service.MascotaService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="/api", produces= "application/json")
public class MascotaController {

	@Autowired
    private MascotaService mascotaService;
	
	//No utilizo ningun Optional porque al hacer los services, el propio mascotaService es el que llama al mascotaRepository
	//y no estaría llamandolo desde el RestController
	
    // 1) Mostrar Mascota por ID
    @GetMapping("/mascota/{id}")
    public ResponseEntity<Mascota> getMascotaById(@PathVariable("id") Long id) {
        Mascota mascota = mascotaService.getById(id);
        return new ResponseEntity<>(mascota, HttpStatus.OK);
    }

    // 2) Subir una Mascota
    @PostMapping(path = "/mascota", consumes = "application/json")
    public ResponseEntity<Mascota> addMascota(@RequestBody Mascota mascota) {
        Mascota savedMascota = mascotaService.save(mascota);
        return new ResponseEntity<>(savedMascota, HttpStatus.CREATED);
    }

    // 3) Listar todas las mascotas
    @GetMapping("/mascota")
    public ResponseEntity<List<Mascota>> getAllMascotas() {
        return new ResponseEntity<>(mascotaService.getAll(), HttpStatus.OK);
    }

    // 4) Listar mascotas por raza
    @GetMapping("/mascota/raza/{raza}")
    public ResponseEntity<List<Mascota>> getMascotasByRaza(@PathVariable String raza) {
        return new ResponseEntity<>(mascotaService.getByRaza(raza), HttpStatus.OK);
    }

    // 5) Listar las 20 mascotas más jóvenes
    @GetMapping("/mascota/jovenes")
    public ResponseEntity<List<Mascota>> getTop20YoungestMascotas() {
        return new ResponseEntity<>(mascotaService.getTop20Youngest(), HttpStatus.OK);
    }

    // 6) Mostrar mascotas paginadas de a 5
    @GetMapping("/mascota/page/{page}")
    public ResponseEntity<List<Mascota>> getMascotasByPage(@PathVariable int page) {
        return new ResponseEntity<>(mascotaService.getMascotasByPage(page), HttpStatus.OK);
    }

    // 7) Borrar una Mascota
    @DeleteMapping("/mascota/{id}")
    public Map<String, Boolean> deleteMascota(@PathVariable("id") Long id) {
        mascotaService.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    // 8) Mostrar todas las mascotas de un propietario
    @GetMapping("/propietario/{id}/mascotas")
    public ResponseEntity<List<Mascota>> getMascotasByPropietario(@PathVariable Long id) {
        return new ResponseEntity<>(mascotaService.getByPropietario(id), HttpStatus.OK);
    }

    // 9) Mostrar propietario de una mascota
    @GetMapping("/mascota/{id}/propietario")
    public ResponseEntity<Propietario> getPropietarioByMascota(@PathVariable Long id) {
        return new ResponseEntity<>(mascotaService.getPropietarioByMascota(id), HttpStatus.OK);
    }
}

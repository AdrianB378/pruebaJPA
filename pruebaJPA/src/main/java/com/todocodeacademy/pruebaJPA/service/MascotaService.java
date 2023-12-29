
package com.todocodeacademy.pruebaJPA.service;

import com.todocodeacademy.pruebaJPA.model.Mascota;

import com.todocodeacademy.pruebaJPA.repository.IMascotaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaService implements IMascotaService {
    
    @Autowired
    private IMascotaRepository mascoRepo;

    @Override
    public List<Mascota> getMascotas() {
        List<Mascota> listaMascotas = mascoRepo.findAll();
        return listaMascotas;  
    }

    @Override
    public void saveMascota(Mascota masco) {
        mascoRepo.save(masco);
    }

    @Override
    public void deleteMascota(Long id) {
        mascoRepo.deleteById(id);
    }

    @Override
    public Mascota findMascota(Long id) {
        Mascota masco = mascoRepo.findById(id).orElse(null);
        return masco;
    
    }

    @Override
    public void editMascota(Long idOriginal, Long nuevaId_mascota, String nuevoNombre, String nuevaEspecie, String nuevaRaza, String nuevoColor) {
      // Busco el objeto original
      Mascota masco = this.findMascota(idOriginal);
      
      // proceso de modificacion a nivel logico
      masco.setId_mascota(nuevaId_mascota);
      masco.setNombre(nuevoNombre);
      masco.setEspecie(nuevaEspecie);
      masco.setRaza(nuevaRaza);
      masco.setColor(nuevoColor);
      
      //guardar los cambios
      this.saveMascota(masco);
      
    }   

   
    
}

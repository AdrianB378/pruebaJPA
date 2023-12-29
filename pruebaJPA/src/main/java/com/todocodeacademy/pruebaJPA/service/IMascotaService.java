
package com.todocodeacademy.pruebaJPA.service;

import com.todocodeacademy.pruebaJPA.model.Mascota;

import java.util.List;

public interface IMascotaService {
    
    // Metodo para traer  a todas las mascotas
    // lectura 
    public List<Mascota> getMascotas();
    
    //alta
    public void saveMascota(Mascota masco);
    
    // baja
    public void deleteMascota(Long id);
    
    // lectura de un solo objeto
    public Mascota findMascota (Long id);
    
    // edicion/modificacion
    public void editMascota(Long idOriginal, Long nuevaId_mascota, 
                            String nuevoNombre,
                            String nuevaEspecie,
                            String nuevaRaza,
                            String nuevoColor);
    
    
}

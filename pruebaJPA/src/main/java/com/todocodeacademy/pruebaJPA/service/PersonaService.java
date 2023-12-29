
package com.todocodeacademy.pruebaJPA.service;

import com.todocodeacademy.pruebaJPA.model.Persona;
import com.todocodeacademy.pruebaJPA.repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {
    
    @Autowired
    private IPersonaRepository persoRepo;

    @Override
    public List<Persona> getPersonas() {
        List<Persona> listaPersonas = persoRepo.findAll();
        return listaPersonas;
    }

    @Override
    public void savePersona(Persona perso) {
        persoRepo.save(perso);
        
    }

    @Override
    public void deletePersona(Long id) {
        persoRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona perso = persoRepo.findById(id).orElse(null);
        return perso;
    }

    @Override
    public void editPersona(Long idOriginal, Long idNueva, String nuevoNombre, String nuevoApellido, int nuevaEdad) {
      // Busco el objeto original
      Persona perso = this.findPersona(idOriginal);
      
      // proceso de modificacion a nivel logico
      perso.setId(idNueva);
      perso.setNombre(nuevoNombre);
      perso.setApellido(nuevoApellido);
      perso.setEdad(nuevaEdad);
      
      //guardar los cambios
      this.savePersona(perso);
      
      
      
    }

    @Override
    public void editPersona(Persona per) {// Podemos hacer este metodo edit junto
        this.savePersona(per);       // con el otro por si necesitamos cambiar
    }                                     // la id sino no necesitamos hacer los 2
                                          // metodos sino el mas pequeño, el segundo
}                                         // en el que podemos cambiar todos los atributos
                                          // menos el de la id
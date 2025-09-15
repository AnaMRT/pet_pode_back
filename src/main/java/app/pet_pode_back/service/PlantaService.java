
package app.pet_pode_back.service;

import app.pet_pode_back.model.Pet;
import app.pet_pode_back.model.Plantas;
import app.pet_pode_back.model.Usuario;
import app.pet_pode_back.repository.PetRepository;
import app.pet_pode_back.repository.PlantaRepository;
import app.pet_pode_back.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlantaService {


    @Autowired
    private PlantaRepository plantaRepository;

    public Plantas cadastrar(@Valid Plantas plantas) {

        plantaRepository.save(plantas);
        return plantas;
    }

    public List<Plantas> listarTodos() {
        return plantaRepository.findAll();
    }

  public List<Plantas> findByNomePoular(String nomePopular) {
        return plantaRepository.findByNomePopular(nomePopular);
    }

    public List<Plantas> findByNomeCientifico(String nomeCientifico) {
        return plantaRepository.findByNomeCientifico(nomeCientifico);
    }


}

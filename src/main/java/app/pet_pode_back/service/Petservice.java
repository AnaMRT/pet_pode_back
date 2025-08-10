package app.pet_pode_back.service;

import app.pet_pode_back.model.Pet;
import app.pet_pode_back.model.Usuario;
import app.pet_pode_back.repository.PetRepository;
import app.pet_pode_back.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Petservice {

    @Autowired
    private PetRepository petRepository;

    public Pet cadastrar(@Valid Pet pet) {
        System.out.println("🐾 Cadastrando pet: " + pet.getNome() + ", dono: " + (pet.getUsuario() != null ? pet.getUsuario().getEmail() : "NULO"));
        return petRepository.save(pet);
    }


    public List<Pet> listarTodos() {
        return petRepository.findAll();
    }


}

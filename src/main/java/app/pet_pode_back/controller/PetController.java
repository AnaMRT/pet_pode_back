package app.pet_pode_back.controller;

import app.pet_pode_back.model.Pet;
import app.pet_pode_back.model.Usuario;
import app.pet_pode_back.repository.PetRepository;
import app.pet_pode_back.repository.UsuarioRepository;
import app.pet_pode_back.service.Petservice;
import app.pet_pode_back.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(path = "pet")
public class PetController {

    @Autowired
    private Petservice petService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PetRepository petRepository;

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Pet>> get() {
        return ResponseEntity.status(HttpStatus.OK).body(petService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Pet> cadastrar(@RequestBody Pet pet, Principal principal) {
        String emailDoUsuarioLogado = principal.getName();

        Usuario usuario = usuarioRepository.findByEmail(emailDoUsuarioLogado)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        pet.setUsuario(usuario);
        Pet salvo = petRepository.save(pet);

        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

}

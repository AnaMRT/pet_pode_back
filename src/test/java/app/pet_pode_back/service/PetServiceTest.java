package app.pet_pode_back.service;

import app.pet_pode_back.model.Pet;
import app.pet_pode_back.model.Usuario;
import app.pet_pode_back.repository.PetRepository;
import app.pet_pode_back.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PetServiceTest {

    @Mock
    private PetRepository petRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private Petservice petService;

    private Usuario usuario;
    private Pet pet;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        usuario = new Usuario();
        usuario.setId(UUID.randomUUID());
        usuario.setNome("João");
        usuario.setEmail("joao@email.com");
        usuario.setSenha("senha123");

        pet = new Pet();
        pet.setNome("Rex");
        pet.setEspecie("Cachorro");
    }

    @Test
    public void SalvarPetComSucesso() {
        when(usuarioRepository.findById(usuario.getId())).thenReturn(Optional.of(usuario));
        when(petRepository.save(any(Pet.class))).thenAnswer(i -> i.getArgument(0));

        Pet petSalvo = petService.salvarPet(pet, usuario.getId());

        assertEquals("Rex", petSalvo.getNome());
        assertEquals("Cachorro", petSalvo.getEspecie());
        assertEquals(usuario, petSalvo.getUsuario());
    }


    @Test
    void deveListarPetsComSucesso() {
        List<Pet> listaPet = new ArrayList<>();
        Pet pet1 = new Pet();
        pet1.setId(UUID.randomUUID());
        pet1.setNome("Teste");
        pet1.setEspecie("canino");
        listaPet.add(pet1);

        when(petRepository.findAll()).thenReturn(listaPet);

        List<Pet> retorno = petService.listarTodos();

        verify(petRepository, times(1)).findAll();
        assertEquals(1, retorno.size(), "Não retornou o tamanho correto");
        assertEquals(listaPet.get(0).getId(), retorno.get(0).getId(), "Não retornou o pet correto");
    }
}

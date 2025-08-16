package app.pet_pode_back.service;


import app.pet_pode_back.model.Usuario;
import app.pet_pode_back.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        usuario = new Usuario();
        usuario.setNome("Teste");
        usuario.setEmail("teste@email.com");
        usuario.setSenha("senha123");
        usuario.setId(UUID.randomUUID());
    }

    @Test
    void deveCadastrarUsuarioComSucesso() {
        when(passwordEncoder.encode(usuario.getSenha())).thenReturn("senhaCriptografada");
        when(usuarioRepository.findByEmail(usuario.getEmail())).thenReturn(Optional.empty());
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario usuarioSalvo = usuarioService.cadastrar(usuario);

        assertNotNull(usuarioSalvo);
        assertEquals("Teste", usuarioSalvo.getNome());
        verify(usuarioRepository, times(1)).save(usuario);
    }

}

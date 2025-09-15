package app.pet_pode_back.controller;

import app.pet_pode_back.model.Usuario;
import app.pet_pode_back.repository.UsuarioRepository;
import app.pet_pode_back.service.EmailService;
import app.pet_pode_back.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class PasswordResetController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EmailService emailService;


    @Autowired
    private UsuarioRepository usuarioRepository;



    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam("email") String email) {
        try {
            Usuario usuario = usuarioRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

            String token = UUID.randomUUID().toString();
            usuario.setResetToken(token);
            usuarioRepository.save(usuario);

            emailService.enviarEmail(
                    usuario.getEmail(),
                    "Recuperação de senha",
                    "Use este token para redefinir sua senha: " + token
            );

            return ResponseEntity.ok("E-mail de recuperação enviado para: " + email);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro interno: " + e.getMessage());
        }
    }



    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam String token, @RequestParam String novaSenha) {
        usuarioService.atualizarSenha(token, novaSenha);
        return "Senha atualizada com sucesso!";
    }
}

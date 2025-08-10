package app.pet_pode_back.exception;


public class RegistroNaoEcontradoException extends RuntimeException {

    public RegistroNaoEcontradoException(String mensagem) {
        super(mensagem);
    }
}

package app.pet_pode_back.exception;

public class ParmetroInvalidoException extends  RuntimeException {
    private String mensagem;

    public ParmetroInvalidoException(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}

package com.api.exception;

/**
 *
 * @author Miguel Castro
 */
public class MensagemException {

    private String mensagemUsuario;
    private String mensagemDesenvolvedor;

    public MensagemException(String mensagemUsuario, String mensagemDesenvolvedor) {
        this.mensagemUsuario = mensagemUsuario;
        this.mensagemDesenvolvedor = mensagemDesenvolvedor;
    }

    public String getMensagemUsuario() {
        return mensagemUsuario;
    }

    public void setMensagemUsuario(String mensagemUsuario) {
        this.mensagemUsuario = mensagemUsuario;
    }

    public String getMensagemDesenvolvedor() {
        return mensagemDesenvolvedor;
    }

    public void setMensagemDesenvolvedor(String mensagemDesenvolvedor) {
        this.mensagemDesenvolvedor = mensagemDesenvolvedor;
    }
}

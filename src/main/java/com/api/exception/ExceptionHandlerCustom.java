package com.api.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Miguel Castro
 */
@ControllerAdvice
public class ExceptionHandlerCustom extends ResponseEntityExceptionHandler {

    private List<MensagemException> gerarListaDeMensagens(BindingResult bindingResult) {

        List<MensagemException> mensagem = new ArrayList<>();

        bindingResult.getFieldErrors().forEach(erro -> {
            String mensagemUsuario = erro.getDefaultMessage();
            String mensagemDesenvolvedor = erro.toString();
            mensagem.add(new MensagemException(mensagemUsuario, mensagemDesenvolvedor));
        });
        return mensagem;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        List<MensagemException> mensagem = gerarListaDeMensagens(ex.getBindingResult());
        return handleExceptionInternal(ex, mensagem, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(ValorExistenteException.class)
    public ResponseEntity<Object> handleValorExistenteException(ValorExistenteException ex, WebRequest request) {

        String mensagemUsuario = ex.getMessage();
        String mensagemDesenvolvedor = ex.getMessage();

        List<MensagemException> mensagem = Arrays.asList(new MensagemException(mensagemUsuario, mensagemDesenvolvedor));

        return handleExceptionInternal(ex, mensagem, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}

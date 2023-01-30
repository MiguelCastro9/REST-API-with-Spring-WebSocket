package com.api.dto;

import com.api.model.PessoaModel;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Miguel Castro
 */
@Schema(name = "Pessoa request DTO")
public class PessoaRequestDto {

    @NotBlank(message = "Nome é obrigatório.")
    @Length(min = 3, max = 40, message = "Nome requer no mínimo {min} e no máximo {max} caracteres.")
    private String nome;

    @Email
    @NotBlank(message = "E-mail é obrigatório.")
    @Length(min = 3, max = 40, message = "E-mail requer no mínimo {min} e no máximo {max} caracteres.")
    private String email;

    //Método para converter entidade em DTO e salvar.
    public PessoaModel converterPessoaDtoParaEntidade() {
        return new PessoaModel(nome, email);
    }
}

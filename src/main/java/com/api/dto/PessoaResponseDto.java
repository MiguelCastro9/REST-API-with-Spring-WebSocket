package com.api.dto;

import com.api.model.PessoaModel;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 *
 * @author Miguel Castro
 */
@Schema(name = "Pessoa response DTO")
public class PessoaResponseDto {

    private Long id;
    private String nome;
    private String email;

    public PessoaResponseDto(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    //Método para converter entidade em DTO.
    public static PessoaResponseDto converterParaPessoaDto(PessoaModel pessoaModel) {
        return new PessoaResponseDto(pessoaModel.getId(), pessoaModel.getNome(), pessoaModel.getEmail());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package com.api.controller;

import com.api.dto.PessoaRequestDto;
import com.api.dto.PessoaResponseDto;
import com.api.model.PessoaModel;
import com.api.service.PessoaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Miguel Castro
 */
@Tag(name = "Pessoa")
@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @GetMapping("/listar")
    public ResponseEntity<List<PessoaResponseDto>> listar() {

        return new ResponseEntity<List<PessoaResponseDto>>(
                pessoaService.listar().stream().map(pessoa
                        -> PessoaResponseDto.converterEntidadeParaPessoaDto(pessoa))
                        .collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping("/salvar")
    public ResponseEntity<PessoaResponseDto> salvar(@Valid @RequestBody PessoaRequestDto pessoaRequestDto) {

        PessoaModel pessoaSalva = pessoaService.salvar(pessoaRequestDto.converterPessoaDtoParaEntidade());
        return new ResponseEntity<PessoaResponseDto>(PessoaResponseDto.converterEntidadeParaPessoaDto(pessoaSalva), HttpStatus.CREATED);

    }
}
package com.api.service;

import com.api.model.PessoaModel;
import com.api.repository.PessoaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miguel Castro
 */
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaModel salvar(PessoaModel pessoaModel) {

        return pessoaRepository.save(pessoaModel);
    }

    public List<PessoaModel> listar() {

        return pessoaRepository.findAll();
    }
}

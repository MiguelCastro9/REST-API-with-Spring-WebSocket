package com.api.service;

import com.api.exception.ValorExistenteException;
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
        
        verificarEmailExistente(pessoaModel);
        return pessoaRepository.save(pessoaModel);
    }

    public List<PessoaModel> listar() {

        return pessoaRepository.findAll();
    }
    
    private void verificarEmailExistente(PessoaModel pessoaModel) {
        
        PessoaModel pessoaEncontrada = pessoaRepository.findByEmail(pessoaModel.getEmail());
        
        if (pessoaEncontrada != null) {
            throw new ValorExistenteException(String.format("O e-mail [%s] já existe.", pessoaModel.getEmail()));
        }
    }
}

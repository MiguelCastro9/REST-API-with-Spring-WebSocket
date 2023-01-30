package com.api.repository;

import com.api.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Miguel Castro
 */
@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
    
}

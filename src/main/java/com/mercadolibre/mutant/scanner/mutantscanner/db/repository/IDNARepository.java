package com.mercadolibre.mutant.scanner.mutantscanner.db.repository;


import com.mercadolibre.mutant.scanner.mutantscanner.db.entity.DNAEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IDNARepository extends CrudRepository<DNAEntity, Long> {
    /**
     *
     * @return count of humans
     */
    public long countByMutantFalse();

    /**
     *
     * @return count of mutants
     */
    public long countByMutantTrue();

    /**
     * return dna entity
     * @param dnaPattern
     * @return
     */
    public Optional<DNAEntity> findByDnaPattern(String dnaPattern);

}

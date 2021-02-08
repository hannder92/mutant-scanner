package com.mercadolibre.mutant.scanner.mutantscanner.domain.repository;

import com.mercadolibre.mutant.scanner.mutantscanner.db.entity.DNAEntity;

import java.util.Optional;

public interface DNARepository {

    /**
     *
     * @return Total Mutants Scanned
     */
    long countByMutantTrue();

    /**
     *
     * @return Total Humans Scanned
     */
    long countByMutantFalse();


    /**
     * return DNA by Pattern
     * @param dnaPattern
     * @return Optional<DNA>
     */
    Optional<DNAEntity> findByDnaPattern(String dnaPattern);

    /**
     * save DNA patern
     * @param dna
     * @param isMutant
     */
    void save(String[] dna, boolean isMutant);
}

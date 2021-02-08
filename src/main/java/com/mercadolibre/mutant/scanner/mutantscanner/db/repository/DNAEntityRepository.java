package com.mercadolibre.mutant.scanner.mutantscanner.db.repository;

import com.mercadolibre.mutant.scanner.mutantscanner.db.entity.DNAEntity;
import com.mercadolibre.mutant.scanner.mutantscanner.domain.repository.DNARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Optional;


@Repository
public class DNAEntityRepository implements DNARepository {


    @Autowired
    private IDNARepository dnaRepository;

    @Override
    public long countByMutantTrue() {
        return dnaRepository.countByMutantTrue();
    }

    @Override
    public long countByMutantFalse() {
        return dnaRepository.countByMutantFalse();
    }

    @Override
    public Optional<DNAEntity> findByDnaPattern(String dnaPattern) {
        return dnaRepository.findByDnaPattern(dnaPattern);
    }


    @Override
    public void save(String[] dna, boolean isMutant) {
        DNAEntity dnaToSave = new DNAEntity();
        dnaToSave.setDnaPattern(Arrays.toString(dna));
        dnaToSave.setMutant(isMutant);
        dnaRepository.save(dnaToSave);
    }
}

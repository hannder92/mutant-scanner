package com.mercadolibre.mutant.scanner.mutantscanner.service.impl;

import com.mercadolibre.mutant.scanner.mutantscanner.db.entity.DNAEntity;
import com.mercadolibre.mutant.scanner.mutantscanner.db.repository.IDNARepository;
import com.mercadolibre.mutant.scanner.mutantscanner.domain.repository.DNARepository;
import com.mercadolibre.mutant.scanner.mutantscanner.service.IDNAScannerService;
import com.mercadolibre.mutant.scanner.mutantscanner.utils.MatrixUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class DNAScannerServiceImpl implements IDNAScannerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DNAScannerServiceImpl.class);

    @Autowired
    private DNARepository dnaRepository;

    /**
     *
     * @param dna
     * @return true if dna belongs to mutant or else false
     */
    @Override
    public boolean isMutant(String[] dna) {
        Optional<DNAEntity> dnaExist = dnaRepository.findByDnaPattern(Arrays.toString(dna));
        if (dnaExist.isPresent()) {
            LOGGER.info("DNA pattern already exists, return results... ");
            return dnaExist.get().isMutant();
        } else {
            LOGGER.info("DNA pattern does not exists, analizyng...");
            String[][] matrix = MatrixUtils.getMatrixByStringArray(dna);
            boolean isMutant = MatrixUtils.evaluateArrays(MatrixUtils.getCombinations(matrix));
            dnaRepository.save(dna,isMutant);
            return isMutant;
        }
    }
}

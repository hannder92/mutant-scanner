package com.mercadolibre.mutant.scanner.mutantscanner.service.impl;

import com.mercadolibre.mutant.scanner.mutantscanner.db.repository.IDNARepository;
import com.mercadolibre.mutant.scanner.mutantscanner.domain.dto.StatsResponseDTO;
import com.mercadolibre.mutant.scanner.mutantscanner.domain.repository.DNARepository;
import com.mercadolibre.mutant.scanner.mutantscanner.service.IStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsServiceImpl implements IStatsService {

    @Autowired
    private DNARepository dnaRepository;

    @Override
    public StatsResponseDTO getStats() {
        StatsResponseDTO response = new StatsResponseDTO();
        long humans = dnaRepository.countByMutantFalse();
        long mutants = dnaRepository.countByMutantTrue();
        double ratio = humans==0? mutants: (mutants/humans);
        response.setCountHumanDNA(humans);
        response.setCountMutantDNA(mutants);
        response.setRatio(ratio);
        return response;
    }
}

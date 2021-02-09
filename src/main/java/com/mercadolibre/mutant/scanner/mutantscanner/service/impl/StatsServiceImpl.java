package com.mercadolibre.mutant.scanner.mutantscanner.service.impl;

import com.mercadolibre.mutant.scanner.mutantscanner.db.repository.IDNARepository;
import com.mercadolibre.mutant.scanner.mutantscanner.domain.dto.StatsResponseDTO;
import com.mercadolibre.mutant.scanner.mutantscanner.domain.repository.DNARepository;
import com.mercadolibre.mutant.scanner.mutantscanner.service.IStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.NumberFormat;

@Service
public class StatsServiceImpl implements IStatsService {

    @Autowired
    private DNARepository dnaRepository;

    @Override
    public StatsResponseDTO getStats() {
        StatsResponseDTO response = new StatsResponseDTO();
        double humans = dnaRepository.countByMutantFalse();
        double mutants = dnaRepository.countByMutantTrue();
        double ratio = humans==0? mutants: (mutants/humans);
        response.setCountHumanDNA((long) humans);
        response.setCountMutantDNA((long) mutants);
        response.setRatio(ratio);
        return response;
    }
}

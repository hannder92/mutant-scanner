package com.mercadolibre.mutant.scanner.mutantscanner.service;


import com.mercadolibre.mutant.scanner.mutantscanner.db.repository.IDNARepository;
import com.mercadolibre.mutant.scanner.mutantscanner.domain.dto.StatsResponseDTO;
import com.mercadolibre.mutant.scanner.mutantscanner.domain.repository.DNARepository;
import com.mercadolibre.mutant.scanner.mutantscanner.service.impl.StatsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatsServiceTest {

    @InjectMocks
    private StatsServiceImpl statsService;

    @Mock
    private DNARepository dnaRepository;

    @Test
    public void statsService(){
        when(dnaRepository.countByMutantTrue()).thenReturn(40L);
        when(dnaRepository.countByMutantFalse()).thenReturn(100L);
        StatsResponseDTO response = statsService.getStats();
        System.out.println("response.toString() = " + response.toString());
    }
}

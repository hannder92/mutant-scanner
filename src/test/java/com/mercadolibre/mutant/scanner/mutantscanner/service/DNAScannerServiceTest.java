package com.mercadolibre.mutant.scanner.mutantscanner.service;


import com.mercadolibre.mutant.scanner.mutantscanner.db.entity.DNAEntity;
import com.mercadolibre.mutant.scanner.mutantscanner.db.repository.IDNARepository;
import com.mercadolibre.mutant.scanner.mutantscanner.domain.repository.DNARepository;
import com.mercadolibre.mutant.scanner.mutantscanner.service.impl.DNAScannerServiceImpl;
import com.mercadolibre.mutant.scanner.mutantscanner.utils.TestConstants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

//@WebMvcTest(DNAScannerServiceImpl.class)
@ExtendWith(MockitoExtension.class)
public class DNAScannerServiceTest {

    @InjectMocks
    private DNAScannerServiceImpl dnaScannerService;

    @Mock
    private DNARepository dnaRepository;

    @Test
    public void DNAScannerServiceIsMutantTrue() {
        when(dnaRepository.findByDnaPattern(anyString())).thenReturn(Optional.of(new DNAEntity(1L, Arrays.toString(TestConstants.MUTANT_DNA), true )));
        assertTrue(dnaScannerService.isMutant(TestConstants.MUTANT_DNA));
    }

    @Test
    public void DNAScannerServiceIsMutantFalse() {
        when(dnaRepository.findByDnaPattern(anyString())).thenReturn(Optional.of(new DNAEntity(2L, Arrays.toString(TestConstants.HUMAN_DNA), false )));
        assertFalse(dnaScannerService.isMutant(TestConstants.HUMAN_DNA));
    }

    @Test
    public void DNAScannerServiceWhenDNADoesNotExistsInDatabase(){
        when(dnaRepository.findByDnaPattern(anyString())).thenReturn(Optional.empty());
        assertFalse(dnaScannerService.isMutant(TestConstants.HUMAN_DNA));
    }

 }

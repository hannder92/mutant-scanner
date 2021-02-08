package com.mercadolibre.mutant.scanner.mutantscanner.service;

import com.mercadolibre.mutant.scanner.mutantscanner.domain.dto.StatsResponseDTO;


public interface IStatsService {
    /**
     *
     * @return stadistics information
     */
    StatsResponseDTO getStats();
}

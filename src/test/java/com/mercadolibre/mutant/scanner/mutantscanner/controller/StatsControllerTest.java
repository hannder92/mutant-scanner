package com.mercadolibre.mutant.scanner.mutantscanner.controller;

import com.mercadolibre.mutant.scanner.mutantscanner.domain.dto.StatsResponseDTO;
import com.mercadolibre.mutant.scanner.mutantscanner.service.IStatsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StatsController.class)
public class StatsControllerTest{

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IStatsService statsService;

    @Test
    public void getStats() throws Exception {
        Mockito.when(statsService.getStats()).thenReturn(new StatsResponseDTO(40L,100L, (double) (40/100)));
        // Call Post "/mutant/" application/json
        mockMvc.perform(get("/stats"))
                .andExpect(status().isOk());
    }

}
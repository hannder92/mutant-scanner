package com.mercadolibre.mutant.scanner.mutantscanner.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.mutant.scanner.mutantscanner.domain.dto.DNARequestDTO;
import com.mercadolibre.mutant.scanner.mutantscanner.service.IDNAScannerService;
import com.mercadolibre.mutant.scanner.mutantscanner.utils.TestConstants;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DNAScannerController.class)
public class DNAScannerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IDNAScannerService dnaScannerService;

    @Test
    public void DNAScanWhenResponseIsTrue() throws Exception {
        Mockito.when(dnaScannerService.isMutant(Mockito.any())).thenReturn(Boolean.TRUE);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(new DNARequestDTO(TestConstants.MUTANT_DNA));
        // Call Post "/mutant/" application/json
        mockMvc.perform(post("/mutant/").contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk());
    }

    @Test
    public void DNAScanWhenIdResponseIsFalse() throws Exception {

        Mockito.when(dnaScannerService.isMutant(Mockito.any())).thenReturn(Boolean.FALSE);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(new DNARequestDTO(TestConstants.HUMAN_DNA));
        // Call Post "/mutant/" application/json
        mockMvc.perform(post("/mutant/").contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isForbidden());
    }

    @Test
    public void DNAScanWhenBodyIsNull() throws Exception {
        // Call Post "/mutant/" application/json
        mockMvc.perform(post("/mutant/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void DNAScanWhenBodyIsEmpty() throws Exception {
        // Call Post "/mutant/" application/json
        mockMvc.perform(post("/mutant/").accept(MediaType.APPLICATION_JSON).content(""))
                .andExpect(status().isBadRequest());
    }


}

package com.mercadolibre.mutant.scanner.mutantscanner;

import com.mercadolibre.mutant.scanner.mutantscanner.domain.dto.DNARequestDTO;
import com.mercadolibre.mutant.scanner.mutantscanner.domain.dto.StatsResponseDTO;
import com.mercadolibre.mutant.scanner.mutantscanner.utils.TestConstants;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest//(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MutantScannerApplicationTests {

//	@Autowired
//	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() throws JSONException {
//		String response = this.restTemplate.postForObject ("/mutant/", new DNARequestDTO(TestConstants.MUTANT_DNA),String.class);
//		JSONAssert.assertEquals("{\"message\":\"Dna scanned belongs to a mutant\"}",response,false);
//
//		response = this.restTemplate.postForObject ("/mutant/", new DNARequestDTO(TestConstants.HUMAN_DNA),String.class);
//		JSONAssert.assertEquals("{\"message\":\"Dna Scanned belongs to a human\"}",response,false);
//
//		StatsResponseDTO statsResponse = this.restTemplate.getForObject ("/stats", StatsResponseDTO.class);
//		JSONAssert.assertEquals("{\"countMutantDNA\":5,\"countHumanDNA\":1,\"ratio\":5.0}",statsResponse.toString(),false);
	}

}

package com.mercadolibre.mutant.scanner.mutantscanner.controller;

import com.mercadolibre.mutant.scanner.mutantscanner.domain.dto.StatsResponseDTO;
import com.mercadolibre.mutant.scanner.mutantscanner.service.IStatsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {

	@Autowired
	private IStatsService statsService;

	@ApiOperation(value = "Get DNA evaluated stats", produces = MediaType.APPLICATION_JSON_VALUE, response = StatsResponseDTO.class)
	@ApiResponse(code = 200, message = "OK")
	@GetMapping()
	public ResponseEntity<StatsResponseDTO> getStats() {
		return new ResponseEntity<StatsResponseDTO>(statsService.getStats(), HttpStatus.OK);
	}

}
